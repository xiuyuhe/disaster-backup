package com.bupt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bupt.domain.SiteInfo;

/**
 * 
 * @author yaosiyu
 *
 */

@RepositoryRestResource()
public interface SiteInfoRepository extends JpaRepository<SiteInfo, String> {

}
