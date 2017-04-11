package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hexiuyu on 2017/4/11.
 */
@Controller
public class DemoController {
    @RequestMapping("/demo")
    public String demoPage(){
        return null;
    }
}
