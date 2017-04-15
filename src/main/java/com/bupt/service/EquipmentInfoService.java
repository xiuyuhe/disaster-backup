package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.EquipmentInfo;
import com.bupt.domain.SiteInfo;
import com.bupt.domain.UserInfo;
import com.bupt.repository.EquipmentInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class EquipmentInfoService extends BasePageService<EquipmentInfo,String> {
    @Autowired
    private EquipmentInfoRepository equipmentInfoRepository;

    @Autowired
    private  SiteInfoService siteInfoService;

    public void save(EquipmentInfo entity){
        equipmentInfoRepository.save(entity);
    }

    public EquipmentInfo findOne(String id){
        return equipmentInfoRepository.findOne(id);
    }

    public void  pageByHql(PageEntity<EquipmentInfo> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from EquipmentInfo where 1=1 ");
        if (paramaMap.containsKey("type")){
            sql.append(" and type =:type ");
        }
        if (paramaMap.containsKey("status")){
            sql.append(" and status =:status ");
        }
        if (paramaMap.containsKey("siteInfoId")){
            sql.append(" and siteInfoId =:siteInfoId ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
    }

    @Override
    protected void translate(List<EquipmentInfo> list) {
        for(EquipmentInfo entity : list){
            if (StringUtils.isNotBlank(entity.getSiteInfoId())){
                SiteInfo siteInfo = siteInfoService.findOne(entity.getSiteInfoId());
                if (siteInfo != null){
                    entity.setSiteName(siteInfo.getName());
                    entity.setSiteCode(siteInfo.getCode());
                }
            }
        }
    }
}
