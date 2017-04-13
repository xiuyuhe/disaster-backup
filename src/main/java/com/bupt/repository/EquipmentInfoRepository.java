package com.bupt.repository;

import com.bupt.domain.EquipmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by wang on 2017/4/13.
 */
@RepositoryRestResource()
public interface EquipmentInfoRepository extends JpaRepository< EquipmentInfo, String> {

}
