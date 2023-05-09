package com.lfz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TitleApplication {
    public static void main(String[] args) {
        SpringApplication.run(TitleApplication.class, args);
    }
}
