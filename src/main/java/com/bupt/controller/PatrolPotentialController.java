package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.PatrolPotential;
import com.bupt.service.PatrolPotentialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bupt.common.base.Constants;
import com.bupt.common.base.PageEntity;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by bupt626 on 17-4-12.
 */
@RestController
@RequestMapping("/patrolPotential")
public class PatrolPotentialController extends BaseCommonController{

    @Autowired
    private PatrolPotentialService patrolPotentialoService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(PatrolPotential entity){
        patrolPotentialoService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping("/page")
    public String page(PatrolPotential entity, Integer start) {
        start = start != null ? start : Constants.INT_ZERO;
        PageEntity<PatrolPotential> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
        patrolPotentialoService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(PatrolPotential entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getCode())) { // 种类编码
            parameterMap.put("code", entity.getCode());
        }
        return parameterMap;
    }

    @RequestMapping("/deleteById")
    public String deleteById(String id) {
        patrolPotentialoService.deleteById(id);
        return sendSuccessMessage();
    }
    @RequestMapping("/findById")
    public String findById(String id){
        PatrolPotential patrolPotential = patrolPotentialoService.findOne(id);
        return sendSuccessMessage(patrolPotential);
    }
}

