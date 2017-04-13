package com.bupt;

import com.bupt.domain.RoleInfo;
import com.bupt.domain.UserInfo;
import com.bupt.service.RoleInfoService;
import com.bupt.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DmApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	UserInfoService userInfoService;

    @Autowired
    RoleInfoService roleInfoService;

	@Test
	public void testUser(){
        UserInfo user = userInfoService.findByName("1325656");
        System.out.println(user);


        RoleInfo role = roleInfoService.findById("1");

    }

}
