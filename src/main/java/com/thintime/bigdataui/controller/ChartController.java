package com.thintime.bigdataui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Thintime
 * @create 2019/11/29
 * @desc TODO 测试Echarts
 */
@Controller
@RequestMapping("/echarts")
public class ChartController {
    @GetMapping("/test")
    public String view() {
        return "index";
    }

    @GetMapping("/view1")
    public String heat() {
        return " v-charts";
    }
}
