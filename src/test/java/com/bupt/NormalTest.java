package com.bupt;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by hexiuyu on 2017/4/13.
 */

public class NormalTest {

    @Test
    public void test() {
        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);
    }
}
