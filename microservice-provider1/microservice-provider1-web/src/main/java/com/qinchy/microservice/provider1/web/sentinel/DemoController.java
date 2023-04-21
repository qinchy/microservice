package com.qinchy.microservice.provider1.web.sentinel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qinchy.microservice.provider1.service.dubbo.FooService;
import com.qinchy.microservice.provider1.service.sentinel.DemoService;
//import org.apache.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/demo")
public class DemoController {

//    @Reference
//    private FooService fooService;

    @Autowired
    private DemoService demoService;

//    @GetMapping("/hello")
//    public String apiSayHello(@RequestParam String name) {
//        return fooService.sayHello(name);
//    }

    @GetMapping("/bonjour/{name}")
    public String apiSayHelloLocal(@PathVariable String name) {
        return demoService.bonjour(name);
    }

//    @GetMapping("/time")
//    public long apiCurrentTime(@RequestParam(value = "slow", defaultValue = "false") Boolean slow) {
//        return fooService.getCurrentTime(slow);
//    }
}
