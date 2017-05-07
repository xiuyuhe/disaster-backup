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
public class MaterialTypeService extends BasePageService<MaterialType,String> {
    @Autowired
    private MaterialTypeRepository repository;

    public void save(MaterialType entity){
        repository.save(entity);
    }
    public  MaterialType findOne(String id){
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
    public void pageByHql(PageEntity<MaterialType> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from MaterialType where 1=1 ");
        if (paramaMap.containsKey("code")) { //种类编码
            sql.append(" and code =:code ");
        }
        if (paramaMap.containsKey("clazz")) { //分类级别
            sql.append(" and clazz =:clazz ");
        }
        if (paramaMap.containsKey("parentCode")) { //上级种类编码
            sql.append(" and parentCode =:parentCode ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
    }
}
