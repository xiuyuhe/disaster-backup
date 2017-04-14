package com.bupt.common.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by hexiuyu on 2017/4/13.
 */
public class CommonUtil {

    public static UserDetails getCurrentUser() {
       return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
