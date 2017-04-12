package com.bupt.repository;

import com.bupt.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bupt626 on 17-4-12.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
}
