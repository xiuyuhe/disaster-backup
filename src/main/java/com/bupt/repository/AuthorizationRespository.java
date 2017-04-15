package com.bupt.repository;

import com.bupt.domain.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wang on 2017/4/15.
 */
public  interface AuthorizationRespository extends JpaRepository<Authorization , String> {

}
