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
import com.bupt.domain.MaterialInfo;
import com.bupt.service.MaterialInfoService;

/**
 * 
 * @author yaosiyu
 *
 */
@RestController
@RequestMapping("/materialInfo")
public class MaterialInfoController extends BaseCommonController {
	@Autowired
	private MaterialInfoService materialInfoService;
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(MaterialInfo materialInfo) {
		materialInfoService.save(materialInfo);
		return sendSuccessMessage();
	}
	
	@RequestMapping("/deleteById")
	public String deleteById(String id) {
		materialInfoService.deleteById(id);
		return sendSuccessMessage();
	}
	@RequestMapping("/findById")
	public String findById(String id){
		MaterialInfo materialInfo = materialInfoService.findOne(id);
		return sendSuccessMessage(materialInfo);
	}
	@RequestMapping(value = "/page")
	public String page(MaterialInfo materialInfo, int start) {
		PageEntity<MaterialInfo> pageEntity = new PageEntity<>(start, Constants.PAGE_SIZE);
		materialInfoService.pageByHql(pageEntity, buildParameter(materialInfo));
		return sendSuccessMessage(pageEntity);
	}

	private Map<String, Object> buildParameter(MaterialInfo materialInfo) {
		Map<String, Object> parameterMap = new HashMap<>();
		if (StringUtils.isNotBlank(materialInfo.getParentTypeCode())) { //种类(中类)
			parameterMap.put("parentTypecode", materialInfo.getParentTypeCode());
		}
		if (StringUtils.isNotBlank(materialInfo.getTypeCode())) { //种类(中类)
			parameterMap.put("typeCode", materialInfo.getTypeCode());
		}
		if (StringUtils.isNotBlank(materialInfo.getName())) { //物资名称
			parameterMap.put("name", "%" + materialInfo.getName() + "%");
		}
		if (StringUtils.isNotBlank(materialInfo.getServiceCycle())) { //固定保养日期
			parameterMap.put("serviceCycle", materialInfo.getServiceCycle());
		}
		if (StringUtils.isNotBlank(materialInfo.getShelfLife())) { //保质期
			parameterMap.put("shelfLife", materialInfo.getShelfLife());
		}
		if (null != materialInfo.getCreateTime()) { //生产日期
			parameterMap.put("createTime", materialInfo.getCreateTime());
		}
		if (null != materialInfo.getLastServiceTime()) { //上次保养日期
			parameterMap.put("lastServiceTime", materialInfo.getLastServiceTime());
		}
		if (StringUtils.isNotBlank(materialInfo.getSiteInfoId())) { //所属站点
			parameterMap.put("siteInfoId", materialInfo.getSiteInfoId());
		}
		return parameterMap;
	}
}
