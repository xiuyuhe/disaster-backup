package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.EquipmentInfo;
import com.bupt.service.EquipmentInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wang on 2017/4/13.
 */

@RestController
@RequestMapping("/equipmentInfo")
public class EquipmentInfoController extends BaseCommonController{
    @Autowired
    private EquipmentInfoService equipmentInfoService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(EquipmentInfo equipmentInfo ) {
        equipmentInfoService.save(equipmentInfo);
        return sendSuccessMessage();

    }


}
