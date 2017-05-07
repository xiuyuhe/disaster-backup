package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.MaterialType;
import com.bupt.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bupt.common.base.Constants;
import com.bupt.common.base.PageEntity;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;


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
    @RequestMapping("/page")
    public String page(MaterialType entity, Integer start) {
        start = start != null ? start : Constants.INT_ZERO;
        PageEntity<MaterialType> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
        materialTypeoService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String, Object> buildParameter(MaterialType entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getCode())) { // 种类编码
            parameterMap.put("code", entity.getCode());
        }
        if (StringUtils.isNotBlank(entity.getClazz())){
            parameterMap.put("clazz",entity.getClazz());
        }
        if (StringUtils.isNotBlank(entity.getParentCode())){
            parameterMap.put("parentCode",entity.getParentCode());
        }
        return parameterMap;
    }

    @RequestMapping("/deleteById")
    public String deleteById(String id) {
        materialTypeoService.deleteById(id);
        return sendSuccessMessage();
    }
    @RequestMapping("/findById")
    public String findById(String id){
        MaterialType materialType = materialTypeoService.findOne(id);
        return sendSuccessMessage(materialType);
    }
}
