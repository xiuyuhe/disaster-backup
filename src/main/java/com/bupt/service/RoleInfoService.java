package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.RoleInfo;
import com.bupt.repository.RoleInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    public void deleteById(String ids){
        if (ids.contains(",")){
            String[] idArray = ids.split(",");
            for (String id : idArray){
                repository.delete(id);
            }
        }else {
            repository.delete(ids);
        }
    }

    public void save(RoleInfo entity) {
        repository.save(entity);
    }

    /**
     * 分页查询
     *
     * @param pageEntity
     * @param paramaMap
     */
    public void pageByHql(PageEntity<RoleInfo> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from RoleInfo where 1=1 ");
        if (paramaMap.containsKey("code")) {
            sql.append(" and code like:code ");
        }
        if (paramaMap.containsKey("roleName")) {
            sql.append(" and roleName =:roleName ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
    }
}
