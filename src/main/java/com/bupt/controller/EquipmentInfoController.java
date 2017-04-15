package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.BaseController;
import com.bupt.common.base.Constants;
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
public class EquipmentInfoController extends BaseCommonController{

    @Autowired
    private EquipmentInfoService equipmentInfooService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(EquipmentInfo entity){
        equipmentInfooService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping("/findById")
    public String findById(String id){
        EquipmentInfo equipmentInfo = equipmentInfooService.findOne(id);
        return sendSuccessMessage(equipmentInfo);
    }

    @RequestMapping("/page")
    public String page(EquipmentInfo entity,Integer start){
        start = start != null?start:Constants.INT_ZERO;
        PageEntity<EquipmentInfo> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
        equipmentInfooService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(EquipmentInfo entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getType())){
            parameterMap.put("name", entity.getType());
        }
        if (StringUtils.isNotBlank(entity.getStatus())){
            parameterMap.put("status", entity.getStatus());
        }
        return parameterMap;
    }
}
