package com.bupt.controller;

import com.bupt.common.utils.CommonUtil;
import com.bupt.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by hexiuyu on 2017/4/11.
 */
@Controller
@RequestMapping("/demo")
@PreAuthorize("hasRole('ADMIN')")
public class DemoController {

    @RequestMapping("")
    public @ResponseBody String demoPage(){
        UserDetails currentUser = CommonUtil.getCurrentUser();
        return "demo";
    }


}
