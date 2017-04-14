package com.bupt.service;

import com.bupt.domain.TaskInfo;
import com.bupt.repository.TaskInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class TaskInfoService {
    @Autowired
    private TaskInfoRepository repository;

    public void save(TaskInfo entity){
        repository.save(entity);
    }
    public void findOne(String id){
        repository.findOne(id);
    }

}
