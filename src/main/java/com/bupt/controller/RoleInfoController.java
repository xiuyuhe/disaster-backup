package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.Constants;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.RoleInfo;
import com.bupt.service.RoleInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/roleInfo")
public class RoleInfoController extends BaseCommonController {

	@Autowired
	private RoleInfoService roleInfoService;

	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(RoleInfo roleInfo) {
		roleInfoService.save(roleInfo);
		return sendSuccessMessage();
	}

	@RequestMapping("/page")
	public String page(RoleInfo entity, int start) {
		PageEntity<RoleInfo> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
		roleInfoService.pageByHql(pageEntity, buildParameter(entity));
		return sendSuccessMessage(pageEntity);
	}

	private Map<String, Object> buildParameter(RoleInfo entity) {
		Map<String, Object> parameterMap = new HashMap<>();
		if (StringUtils.isNotBlank(entity.getCode())) { // 站点名称 模糊查询
			parameterMap.put("code", entity.getCode());
		}
		if (StringUtils.isNotBlank(entity.getRoleName())) { // 主管单位
			parameterMap.put("roleName", entity.getRoleName());
		}
		return parameterMap;
	}

	@RequestMapping("/deleteById")
	public String deleteById(String id) {
		roleInfoService.deleteById(id);
		return sendSuccessMessage();
	}
	@RequestMapping("/findById")
	public String findById(String id){
		RoleInfo roleInfo = roleInfoService.findById(id);
		return sendSuccessMessage(roleInfo);
	}
}
