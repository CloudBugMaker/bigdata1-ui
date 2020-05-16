package com.thintime.bigdataui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Thintime
 * @create 2020/4/25
 * @desc 测试JSP
 */
@Controller
@RequestMapping("/jsp")
public class JspController {
    public String test(){
        return "login";
    }
}
