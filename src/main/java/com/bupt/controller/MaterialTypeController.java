package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.MaterialType;
import com.bupt.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bupt626 on 17-4-12.
 */
@RestController
@RequestMapping("/materialType")
public class MaterialTypeController extends BaseCommonController{

    @Autowired
    private MaterialTypeService materialTypeoService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(MaterialType entity){
        materialTypeoService.save(entity);
        return sendSuccessMessage();
    }
}
