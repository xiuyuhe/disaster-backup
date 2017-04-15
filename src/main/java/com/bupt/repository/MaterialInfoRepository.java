package com.bupt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bupt.domain.MaterialInfo;

/**
 * 
 * @author yaosiyu
 *
 */
@Repository
public interface MaterialInfoRepository extends JpaRepository<MaterialInfo, String> {

}
