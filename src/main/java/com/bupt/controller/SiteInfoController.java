package com.bupt.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.Constants;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.SiteInfo;
import com.bupt.service.SiteInfoService;

@RestController
@RequestMapping("/siteInfo")
public class SiteInfoController extends BaseCommonController {

	@Autowired
	private SiteInfoService siteInfoService;

	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(SiteInfo siteInfo) {
		siteInfoService.save(siteInfo);
		return sendSuccessMessage();
	}

	@RequestMapping("/page")
	public String page(SiteInfo entity, int start) {
		PageEntity<SiteInfo> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
		siteInfoService.pageByHql(pageEntity, buildParameter(entity));
		return sendSuccessMessage(pageEntity);
	}

	private Map<String, Object> buildParameter(SiteInfo entity) {
		Map<String, Object> parameterMap = new HashMap<>();
		if (StringUtils.isNotBlank(entity.getName())) { // 站点名称 模糊查询
			parameterMap.put("name", entity.getName());
		}
		if (null != entity.getCreateTime()) { // 建站时间
			parameterMap.put("createTime", entity.getCreateTime());
		}
		if (StringUtils.isNotBlank(entity.getChargeUnit())) { // 主管单位
			parameterMap.put("chargeUnit", entity.getChargeUnit());
		}
		if (StringUtils.isNotBlank(entity.getPlace())) { // 所属区域
			parameterMap.put("place", entity.getPlace());
		}
		if (StringUtils.isNotBlank(entity.getStatus())) { // 状态
			parameterMap.put("status", entity.getStatus());
		}
		return parameterMap;
	}
}
