package com.bupt.service;

import com.bupt.domain.PatrolPotential;
import com.bupt.repository.PatrolPotentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class PatrolPotentialService {
    @Autowired
    private PatrolPotentialRepository repository;

    public void save(PatrolPotential entity){
        repository.save(entity);
    }
    public void findOne(String id){
        repository.findOne(id);
    }

}
