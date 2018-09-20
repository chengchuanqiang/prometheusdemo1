package com.demo.prometheusdemo1.controller;

import com.demo.prometheusdemo1.common.MyMetrics;
import com.demo.prometheusdemo1.common.annotation.PrometheusCounterMetrics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/********************************
 *** 自定义监控指标
 ***@Author chengchuanqiang
 ***@Date 2018/9/20 15:03
 ***@Version 1.0.0
 ********************************/
@RestController
@RequestMapping("prometheus")
public class PrometheusController {

    /**
     * 计数器
     *
     * @return OK
     */
    @RequestMapping("count")
    public String countExample() {
        MyMetrics.counterExample.labels("success").inc();
        System.out.println("counterExample : " + MyMetrics.counterExample.labels("success").get());
        return "OK";
    }

    /**
     * 仪表
     *
     * @return OK
     */
    @RequestMapping("gauge")
    public String gaugeExample() {
        MyMetrics.gaugeExample.labels("success").set(new Random().nextInt(10));
        System.out.println("gaugeExample : " + MyMetrics.gaugeExample.labels("success").get());
        return "OK";
    }

    /**
     * 注解测试
     *
     * @return OK
     */
    @PrometheusCounterMetrics
    @RequestMapping("test1")
    public String test1() {
        return "OK";
    }

    /**
     * 注解带参
     *
     * @return OK
     */
    @PrometheusCounterMetrics(name = "test22")
    @RequestMapping("test2")
    public String test2() {
        return "OK";
    }
}
