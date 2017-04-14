package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.UserInfo;
import com.bupt.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping("/findByName")
    public String findByName(String userName){
        UserInfo userInfo = userInfoService.findByName(userName);
        return sendSuccessMessage(userInfo);
    }
    @RequestMapping("/page")
    public String page(UserInfo userInfo){
        PageEntity<UserInfo> pageEntity = new PageEntity<>(0,10);
        Map<String,Object> paramMap = new HashMap<>();
        if (!StringUtils.isEmpty(userInfo.getName())){
            paramMap.put("name", userInfo.getName());
        }
        userInfoService.pageByHql(pageEntity,paramMap);
        return sendSuccessMessage(pageEntity);
    }
}
