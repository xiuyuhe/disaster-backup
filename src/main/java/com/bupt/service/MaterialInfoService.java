package com.bupt.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.MaterialInfo;
import com.bupt.domain.SiteInfo;
import com.bupt.repository.MaterialInfoRepository;

/**
 * 
 * @author yaosiyu
 *
 */
@Service
public class MaterialInfoService extends BasePageService<MaterialInfo, String>{
	@Autowired
	private MaterialInfoRepository materialInfoRepository;
	
	@Autowired
	private SiteInfoService siteInfoService;

	public void save(MaterialInfo entity) {
		materialInfoRepository.save(entity);
	}

	public MaterialInfo findOne(String id) {
		return materialInfoRepository.findOne(id);
	}

	@SuppressWarnings("unchecked")
	public void pageByHql(PageEntity<MaterialInfo> pageEntity, Map<String, Object> paramaMap) {
		StringBuilder sql = new StringBuilder(" from MaterialInfo where 1=1 ");
		if (paramaMap.containsKey("parentTypecode")) { //种类(中类)
			sql.append(" and parentTypecode =:parentTypecode ");
		}
		if (paramaMap.containsKey("typeCode")) { //种类(小类)
			sql.append(" and typeCode =:typeCode ");
		}
		if (paramaMap.containsKey("name")) { //物资名称
			sql.append(" and name like:name ");
		}
		if (paramaMap.containsKey("serviceCycle")) { //固定保养日期
			sql.append(" and serviceCycle =:serviceCycle ");
		}
		if (paramaMap.containsKey("shelfLife")) { //保质期
			sql.append(" and shelfLife =:shelfLife ");
		}
		if (paramaMap.containsKey("status")) { //状态
			sql.append(" and status =:status ");
		}
		if (paramaMap.containsKey("createTime")) { //生产日期
			sql.append(" and createTime =:createTime ");
		}
		if (paramaMap.containsKey("lastServiceTime")) { //上次保养日期
			sql.append(" and lastServiceTime =:lastServiceTime ");
		}
		if (paramaMap.containsKey("siteInfoId")) { //所属站点
			sql.append(" and siteInfoId =:siteInfoId ");
		}
		super.pageByHql(sql.toString(), pageEntity, paramaMap);
		translate(pageEntity.getResults());
	}

	@Override
    protected void translate(List<MaterialInfo> materialInfos){
        for (MaterialInfo materialInfo: materialInfos ) {
            if (StringUtils.isNotBlank(materialInfo.getSiteInfoId())){
                SiteInfo siteInfo = siteInfoService.findOne(materialInfo.getSiteInfoId());
                if (siteInfo != null){
                	materialInfo.setSiteCode(siteInfo.getCode());
                	materialInfo.setSiteName(siteInfo.getName());
                }
            }
        }
    }
}
