package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.PatrolPotential;
import com.bupt.service.PatrolPotentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
