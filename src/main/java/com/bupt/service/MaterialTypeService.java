package com.bupt.service;

import com.bupt.domain.MaterialType;
import com.bupt.repository.MaterialTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class MaterialTypeService {
    @Autowired
    private MaterialTypeRepository repository;

    public void save(MaterialType entity){
        repository.save(entity);
    }
    public void findOne(String id){
        repository.findOne(id);
    }

}
