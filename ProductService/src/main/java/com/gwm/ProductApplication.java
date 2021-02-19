package com.gwm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
//代表这是一个Eureka客户端
@EnableDiscoveryClient
public class ProductApplication {
    public static void main(String[] args){

        SpringApplication.run(ProductApplication.class, args);
    }


}
