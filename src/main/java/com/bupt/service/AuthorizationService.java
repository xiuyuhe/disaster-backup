package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Authorization;
import com.bupt.domain.EquipmentInfo;
import com.bupt.repository.AuthorizationRespository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bupt.common.base.PageEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017/4/15.
 */
@Service
@Transactional
public class AuthorizationService extends BasePageService<Authorization,String>{

    @Autowired
    private AuthorizationRespository authorizationRespository;

    public void save(Authorization entity ){authorizationRespository.save(entity);}
    public Authorization findOne(String id){
        return authorizationRespository.findOne(id);
    }

    public void deleteById(String ids){
        if (ids.contains(",")){
            String[] idArray = ids.split(",");
            for (String id : idArray){
                authorizationRespository.delete(id);
            }
        }else {
            authorizationRespository.delete(ids);
        }
    }
    public void  pageByHql(PageEntity<Authorization> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Authorization where 1=1 ");
        if (paramaMap.containsKey("phoneNumber")){
            sql.append(" and phoneNumber =:phoneNumber ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
    }

}
