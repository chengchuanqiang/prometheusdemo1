package com.demo.prometheusdemo1.common.annotation;

import java.lang.annotation.*;

/********************************
 *** 自定义接口访问次数的注解
 ***@Author chengchuanqiang
 ***@Date 2018/9/20 15:57
 ***@Version 1.0.0
 ********************************/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrometheusCounterMetrics {
    /**
     * 默认为空,程序使用method signature作为Metric name
     * 如果name有设置值,使用name作为Metric name
     *
     * @return name
     */
    String name() default "";
}
