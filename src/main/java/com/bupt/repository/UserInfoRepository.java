package com.bupt.repository;

import com.bupt.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by bupt626 on 17-4-12.
 */
@RepositoryRestResource()
public interface UserInfoRepository extends JpaRepository<UserInfo, String> ,JpaSpecificationExecutor {
    UserInfo findByUserName(String name);
}
