package com.bupt.repository;

import com.bupt.domain.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hexiuyu on 2017/4/13.
 */
@Repository
public interface RoleInfoRepository extends JpaRepository<RoleInfo, String> {
}
