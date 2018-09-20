package com.demo.prometheusdemo1.common.aspect;

import com.demo.prometheusdemo1.common.MyMetrics;
import com.demo.prometheusdemo1.common.annotation.PrometheusCounterMetrics;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/********************************
 *** 切面配置
 ***@Author chengchuanqiang
 ***@Date 2018/9/20 16:00
 ***@Version 1.0.0
 ********************************/
@Aspect
@Component
public class PrometheusMetricsAspect {

    /**
     * 自定义Prometheus注解的全路径
     */
    @Pointcut("@annotation(com.demo.prometheusdemo1.common.annotation.PrometheusCounterMetrics)")
    public void pcMethod() {
    }

    @Around(value = "pcMethod() && @annotation(annotation)")
    public Object MetricsCollector(ProceedingJoinPoint joinPoint, PrometheusCounterMetrics annotation) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        PrometheusCounterMetrics prometheusMetrics = methodSignature.getMethod().getAnnotation(PrometheusCounterMetrics.class);
        Object object = null;
        if (prometheusMetrics != null) {
            String name;
            if (StringUtils.isNotEmpty(prometheusMetrics.name())) {
                name = prometheusMetrics.name();
            } else {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                name = request.getRequestURI();
            }
            MyMetrics.requestSuccess.labels(name).inc();
            try {
                object = joinPoint.proceed();
            } catch (Exception e) {
                MyMetrics.requestError.labels(name).inc();
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return object;
    }
}
