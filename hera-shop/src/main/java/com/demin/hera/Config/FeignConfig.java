package com.demin.hera.Config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by  Domain
 * on 2019/6/12 22:57;
 */
@Configuration
public class FeignConfig {

        @Bean
        Logger.Level feignLevel() {
            return Logger.Level.FULL;
        }

}
