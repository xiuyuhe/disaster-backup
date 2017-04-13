package com.bupt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bupt.common.base.BaseCommonController;
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
}
