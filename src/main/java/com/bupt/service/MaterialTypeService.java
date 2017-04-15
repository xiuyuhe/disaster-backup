package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.MaterialType;
import com.bupt.repository.MaterialTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bupt.common.base.PageEntity;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class MaterialTypeService extends BasePageService {
    @Autowired
    private MaterialTypeRepository repository;

    public void save(MaterialType entity){
        repository.save(entity);
    }
    public void findOne(String id){
        repository.findOne(id);
    }
    public void pageByHql(PageEntity<MaterialType> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from MaterialType where 1=1 ");
        if (paramaMap.containsKey("code")) { //站点名称
            sql.append(" and code =:code ");
        }
        if (paramaMap.containsKey("clazz")) { //站点名称
            sql.append(" and clazz =:clazz ");
        }
        if (paramaMap.containsKey("parentCode")) { //站点名称
            sql.append(" and parentCode =:parentCode ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
    }
}
