package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.UserInfo;
import com.bupt.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class UserInfoService extends BasePageService<UserInfo,String> {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public void save(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }
    public UserInfo findOne(String id){
        return  userInfoRepository.findOne(id);
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
        if (paramaMap.containsKey("position")){
            sql.append(" and position =:position ");
        }
        if (paramaMap.containsKey("educational")){
            sql.append(" and educational =:educational ");
        }
        if (paramaMap.containsKey("professional")){
            sql.append(" and professional =:professional ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
    }
}
