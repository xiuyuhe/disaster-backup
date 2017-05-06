package com.bupt.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.SiteInfo;
import com.bupt.repository.SiteInfoRepository;
import java.util.List;

@Service
@Transactional
public class SiteInfoService extends BasePageService<SiteInfo,String> {

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

	/**
	 * 分页查询
	 * @param pageEntity
	 * @param paramaMap
	 */
	public void pageByHql(PageEntity<SiteInfo> pageEntity, Map<String, Object> paramaMap) {
		StringBuilder sql = new StringBuilder(" from SiteInfo where 1=1 ");
		if (paramaMap.containsKey("name")) { //站点名称
			sql.append(" and name =:name ");
		}
		if (paramaMap.containsKey("createTime")) { //建站时间
			sql.append(" and createTime =:createTime ");
		}
		if (paramaMap.containsKey("chargeUnit")) { //主管单位
			sql.append(" and chargeUnit =:chargeUnit ");
		}
		if (paramaMap.containsKey("place")) { //所属区域
			sql.append(" and place =:place ");
		}
		if (paramaMap.containsKey("status")) { //状态
			sql.append(" and status =:status ");
		}
		super.pageByHql(sql.toString(), pageEntity, paramaMap);
	}
}
