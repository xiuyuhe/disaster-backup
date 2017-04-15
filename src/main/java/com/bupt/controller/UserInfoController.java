package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.BaseController;
import com.bupt.common.base.Constants;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.UserInfo;
import com.bupt.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends BaseCommonController {

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
    @RequestMapping("/findById")
    public String findOne(String id){
        UserInfo userInfo = userInfoService.findOne(id);
        return sendSuccessMessage(userInfo);
    }
    @RequestMapping(value = "/page",method = { RequestMethod.POST, RequestMethod.HEAD })
    public String page(UserInfo userInfo,int start){
        PageEntity<UserInfo> pageEntity = new PageEntity<>(start,Constants.PAGE_SIZE);
        userInfoService.pageByHql(pageEntity,buildParameter(userInfo));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(UserInfo userInfo){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(userInfo.getName())){
            parameterMap.put("name", "%"+userInfo.getName()+"%");
        }
        if (StringUtils.isNotBlank(userInfo.getStatus())){
            parameterMap.put("status", userInfo.getStatus());
        }
        return parameterMap;
    }
}
