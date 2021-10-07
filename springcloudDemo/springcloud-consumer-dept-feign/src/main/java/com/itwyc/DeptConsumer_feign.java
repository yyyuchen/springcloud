package com.itwyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心ip和端口~

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.itwyc"})
@ComponentScan("com.itwyc.*")
public class DeptConsumer_feign {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign.class, args);
    }

}
