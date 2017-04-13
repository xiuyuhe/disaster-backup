package com.bupt.service;

import com.bupt.domain.UserInfo;
import com.bupt.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public void save(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }
    public void findOne(String id){
        userInfoRepository.findOne(id);
    }
}
