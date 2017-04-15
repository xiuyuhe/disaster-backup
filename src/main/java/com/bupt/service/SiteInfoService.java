package com.bupt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bupt.domain.SiteInfo;
import com.bupt.repository.SiteInfoRepository;

import java.util.List;

@Service
@Transactional
public class SiteInfoService {
	
	@Autowired
	private SiteInfoRepository siteInfoRepository;

	public void save(SiteInfo siteInfo) {
		siteInfoRepository.save(siteInfo);
	}

	public SiteInfo findOne(String id) {
		return  siteInfoRepository.findOne(id);
	}

	public List<SiteInfo> findAll() {
		return siteInfoRepository.findAll();
	}
}
