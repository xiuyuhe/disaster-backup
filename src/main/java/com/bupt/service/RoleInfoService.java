package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.RoleInfo;
import com.bupt.repository.RoleInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hexiuyu on 2017/4/13.
 */
@Service
public class RoleInfoService extends BasePageService<RoleInfo,String> {
    @Autowired
    RoleInfoRepository repository;

    public RoleInfo findById(String id){
        return repository.findOne(id);
    }

}
