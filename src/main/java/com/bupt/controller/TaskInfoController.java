package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.domain.TaskInfo;
import com.bupt.service.TaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bupt626 on 17-4-12.
 */
@RestController
@RequestMapping("/taskInfo")
public class TaskInfoController extends BaseCommonController{

    @Autowired
    private TaskInfoService taskInfoService;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(TaskInfo entity){
        taskInfoService.save(entity);
        return sendSuccessMessage();
    }
}
