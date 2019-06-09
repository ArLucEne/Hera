package com.demin.hera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class HeraZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeraZuulApplication.class, args);
    }

}
