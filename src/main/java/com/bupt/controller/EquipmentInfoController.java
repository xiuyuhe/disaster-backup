package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.BaseController;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.EquipmentInfo;
import com.bupt.domain.UserInfo;
import com.bupt.service.EquipmentInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@RestController
@RequestMapping("/equipmentInfo")
public class EquipmentInfoController extends BaseController{

    @Autowired
    private EquipmentInfoService equipmentInfooService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(EquipmentInfo entity){
        equipmentInfooService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping("/page")
    public String page(UserInfo userInfo){
        PageEntity<UserInfo> pageEntity = new PageEntity<>(start,pageSize);
        Map<String,Object> parameterMap = new HashMap<>();
        equipmentInfooService.pageByHql(pageEntity,buildParameter(userInfo));
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
