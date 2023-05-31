package com.qinchy.microservice.consumer2.demos.web;

import com.qinchy.microservice.consumer2.demos.web.feignclient.MicroserviceProvider1FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用微服务
 */
@RestController
@RequestMapping("/feginDemo")
public class MicroserviceController {
    @Autowired
    MicroserviceProvider1FeignClient microserviceProvider1FeignClient;

    @GetMapping("/hello")
    public String test(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
        return microserviceProvider1FeignClient.hello(name);
    }
}
