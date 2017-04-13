package com.bupt.config;

import com.bupt.domain.RoleInfo;
import com.bupt.domain.UserInfo;
import com.bupt.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hexiuyu on 2017/4/12.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyAuthenticationProvider provider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }


    @Service("MyUserDetailsImpl")
    public class CustomUserDetailsService implements UserDetailsService {

        @Autowired
        private UserInfoService userInfoService;



        @Override
        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            UserInfo userInfo = userInfoService.findByName(s);
            if (userInfo == null) {
                throw new UsernameNotFoundException("no user found");
            }
            return new MyUserDetails(userInfo);

        }
    }

    public class MyUserDetails extends UserInfo implements UserDetails {

        private List<RoleInfo> roles;

        public MyUserDetails(UserInfo user) {
            super(user);
            this.roles = new ArrayList<>();
            roles.add(user.getRoleInfo());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            if(roles == null || roles.size() <1){
                return AuthorityUtils.commaSeparatedStringToAuthorityList("");
            }
            StringBuilder commaBuilder = new StringBuilder();
            for(RoleInfo role : roles){
                commaBuilder.append(role.getRoleName()).append(",");
            }
            String authorities = commaBuilder.substring(0,commaBuilder.length()-1);
            return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
        }

        @Override
        public String getPassword() {
            return super.getPassword();
        }

        @Override
        public String getUsername() {
            return super.getUserName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }


    @Component
    public class MyAuthenticationProvider implements AuthenticationProvider {

        @Autowired
        private CustomUserDetailsService userService;

        @Autowired
        private PasswordEncoder passwordEncoder;

        /**
         * 自定义验证方式
         */
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            String username = authentication.getName();
            String password = (String) authentication.getCredentials();
            MyUserDetails user = (MyUserDetails) userService.loadUserByUsername(username);
            if(user == null){
                throw new BadCredentialsException("Username not found.");
            }

            //加密过程在这里体现
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new BadCredentialsException("Wrong password.");
            }

            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        }

        @Override
        public boolean supports(Class<?> arg0) {
            return true;
        }

    }

    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
