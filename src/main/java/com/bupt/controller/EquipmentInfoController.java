package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.EquipmentInfo;
import com.bupt.service.EquipmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
