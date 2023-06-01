package com.qinchy.microservice.consumer2.demos.web.feignclient;

import com.qinchy.microservice.consumer2.demos.web.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(contextId = "basic-service", value = "microservice-provider1")
public interface MicroserviceProvider1FeignClient {

    @RequestMapping("/hello")
    @ResponseBody
    String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name);

    @RequestMapping("/user1")
    @ResponseBody
    User user();

    @RequestMapping("/save_user")
    @ResponseBody
    String saveUser(@RequestBody User u);
}
