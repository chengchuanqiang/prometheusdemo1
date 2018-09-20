package com.demo.prometheusdemo1.common;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;

/********************************
 *** 自定义指标
 ***@Author chengchuanqiang
 ***@Date 2018/9/20 15:05
 ***@Version 1.0.0
 ********************************/
public class MyMetrics {

    /**
     * 计数器
     */
    public static final Counter counterExample = Counter
            .build()
            .name("my_sample_counter")
            .labelNames("status")
            .help("计数器")
            .register();

    /**
     * 仪表
     */
    public static final Gauge gaugeExample = Gauge
            .build()
            .name("my_sample_gauge")
            .labelNames("status")
            .help("仪表")
            .register();

    /**
     * 接口访问成功计数器
     */
    public static final Counter requestSuccess = Counter
            .build()
            .name("request_success_counter")
            .labelNames("requestUrl")
            .help("接口访问成功总数")
            .register();

    /**
     * 接口访问失败计数器
     */
    public static final Counter requestError = Counter
            .build()
            .name("request_error_counter")
            .labelNames("requestUrl")
            .help("接口访问失败总数")
            .register();

}
