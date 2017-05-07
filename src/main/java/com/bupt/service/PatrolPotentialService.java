package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.PatrolPotential;
import com.bupt.repository.PatrolPotentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class PatrolPotentialService extends BasePageService<PatrolPotential,String> {
    @Autowired
    private PatrolPotentialRepository repository;

    public void save(PatrolPotential entity) {
        repository.save(entity);
    }

    public PatrolPotential findOne(String id) {
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
    public void pageByHql(PageEntity<PatrolPotential> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from PatrolPotential where 1=1 ");
        if (paramaMap.containsKey("code")) { //种类编码
            sql.append(" and code =:code ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
    }
}

