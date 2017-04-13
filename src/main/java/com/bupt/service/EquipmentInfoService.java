package com.bupt.service;
import com.bupt.domain.EquipmentInfo;
import com.bupt.repository.EquipmentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wang on 2017/4/13.
 */
@Service
@Transactional
public class EquipmentInfoService {
    @Autowired
    private EquipmentInfoRepository equipmentInfoRepository;

    public void save(EquipmentInfo equipmentInfo){
        equipmentInfoRepository.save(equipmentInfo);
    }
    public void findOne(String id){
        equipmentInfoRepository.findOne(id);
    }
}
