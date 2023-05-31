package com.qinchy.microservice.consumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceConsumer2Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumer2Application.class, args);
    }

}
