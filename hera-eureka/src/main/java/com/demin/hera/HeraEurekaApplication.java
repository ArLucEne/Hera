package com.demin.hera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HeraEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeraEurekaApplication.class, args);
    }

}
