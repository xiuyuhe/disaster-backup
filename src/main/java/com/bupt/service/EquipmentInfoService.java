package com.bupt.service;

import com.bupt.domain.EquipmentInfo;
import com.bupt.repository.EquipmentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class EquipmentInfoService {
    @Autowired
    private EquipmentInfoRepository equipmentInfoRepository;

    public void save(EquipmentInfo entity){
        equipmentInfoRepository.save(entity);
    }
    public void findOne(String id){
        equipmentInfoRepository.findOne(id);
    }

}
