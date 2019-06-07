package com.demin.hera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HeraAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeraAdminApplication.class, args);
    }

}
