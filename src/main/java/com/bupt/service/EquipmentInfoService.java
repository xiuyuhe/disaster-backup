package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.EquipmentInfo;
import com.bupt.domain.UserInfo;
import com.bupt.repository.EquipmentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class EquipmentInfoService extends BasePageService {
    @Autowired
    private EquipmentInfoRepository equipmentInfoRepository;

    public void save(EquipmentInfo entity){
        equipmentInfoRepository.save(entity);
    }

    public EquipmentInfo findOne(String id){
        return equipmentInfoRepository.findOne(id);
    }

    public void  pageByHql(PageEntity<EquipmentInfo> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from UserInfo where 1=1 ");
        if (paramaMap.containsKey("type")){
            sql.append(" and type =:type ");
        }
        if (paramaMap.containsKey("status")){
            sql.append(" and status =:status ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
    }
}
