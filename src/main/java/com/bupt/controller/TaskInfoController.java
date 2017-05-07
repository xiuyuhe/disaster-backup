package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.Constants;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.TaskInfo;
import com.bupt.service.TaskInfoService;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
    
	@RequestMapping("/deleteById")
	public String deleteById(String id) {
		taskInfoService.deleteById(id);
		return sendSuccessMessage();
	}
    
    @RequestMapping("/page")
	public String page(TaskInfo entity, Integer start) {
		PageEntity<TaskInfo> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
		taskInfoService.pageByHql(pageEntity, buildParameter(entity));
		return sendSuccessMessage(pageEntity);
	}

	private Map<String, Object> buildParameter(TaskInfo entity) {
		Map<String, Object> parameterMap = new HashMap<>();
		if (StringUtils.isNotBlank(entity.getName())) { // 任务名称 模糊查询
			parameterMap.put("name", "%"+entity.getName()+"%");
		}
		if (StringUtils.isNotBlank(entity.getMember())) { // 接受任务人员
			parameterMap.put("member", entity.getMember());
		}
		if (StringUtils.isNotBlank(entity.getFrequency())) { // 任务频率
			parameterMap.put("frequency", entity.getFrequency());
		}
		return parameterMap;
	}

	@RequestMapping("/findById")
	public String findById(String id){
		TaskInfo taskInfo = taskInfoService.findOne(id);
		return sendSuccessMessage(taskInfo);
	}
}
