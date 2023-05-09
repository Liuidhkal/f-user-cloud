package com.lxs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication.class, args);
    }

}
