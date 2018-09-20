package com.demo.prometheusdemo1;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class Prometheusdemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Prometheusdemo1Application.class, args);
    }
}
