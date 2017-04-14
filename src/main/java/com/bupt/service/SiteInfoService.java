package com.bupt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bupt.domain.SiteInfo;
import com.bupt.repository.SiteInfoRepository;

@Service
@Transactional
public class SiteInfoService {
	
	@Autowired
	private SiteInfoRepository siteInfoRepository;

	public void save(SiteInfo siteInfo) {
		siteInfoRepository.save(siteInfo);
	}

	public void findOne(String id) {
		siteInfoRepository.findOne(id);
	}
}
