package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.Constants;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Authorization;
import com.bupt.domain.EquipmentInfo;
import com.bupt.repository.AuthorizationRespository;
import com.bupt.service.AuthorizationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang on 2017/4/15.
 */

@RestController
@RequestMapping("/authorization")
public class AuthorizationController extends BaseCommonController {
    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Authorization entity){
        authorizationService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping("/page")
    public String page(Authorization entity, int start){
        PageEntity<EquipmentInfo> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
        authorizationService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String, Object> buildParameter(Authorization entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getPhoneNumber())) { // 种类编码
            parameterMap.put("phoneNumber", entity.getPhoneNumber());
        }
        return parameterMap;
    }
}
