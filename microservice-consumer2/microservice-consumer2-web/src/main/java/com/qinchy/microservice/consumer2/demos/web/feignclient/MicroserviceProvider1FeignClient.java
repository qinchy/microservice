package com.qinchy.microservice.consumer2.demos.web.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("microservice-provider1")
public interface MicroserviceProvider1FeignClient {

    @RequestMapping("/hello")
    @ResponseBody
    String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name);
}
