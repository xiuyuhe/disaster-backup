package com.bupt.service;

import com.bupt.common.base.BasePageRepository;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.UserInfo;
import com.bupt.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class UserInfoService extends BasePageRepository<UserInfo,String>{
    @Autowired
    private UserInfoRepository userInfoRepository;

    public void save(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }
    public void findOne(String id){
        userInfoRepository.findOne(id);
    }

    public UserInfo findByName(String name){
        return userInfoRepository.findByUserName(name);
    }


    public void  pageByHql(PageEntity<UserInfo> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from UserInfo where 1=1 ");
        if (paramaMap.containsKey("name")){
            sql.append(" and name like:name ");
        }
        if (paramaMap.containsKey("status")){
            sql.append(" and status =:status ");
        }
        if (paramaMap.containsKey("psition")){
            sql.append(" and psition =:psition ");
        }
        if (paramaMap.containsKey("educational")){
            sql.append(" and educational =:educational ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
    }
}
