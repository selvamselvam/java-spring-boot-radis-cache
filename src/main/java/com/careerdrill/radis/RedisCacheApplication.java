package com.careerdrill.radis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class RedisCacheApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheApplication.class);

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(RedisCacheApplication.class, args);


    }
}