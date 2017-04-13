package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.UserInfo;
import com.bupt.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bupt626 on 17-4-12.
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends BaseCommonController{

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(UserInfo userInfo){
        userInfoService.save(userInfo);
        return sendSuccessMessage();
    }
}
