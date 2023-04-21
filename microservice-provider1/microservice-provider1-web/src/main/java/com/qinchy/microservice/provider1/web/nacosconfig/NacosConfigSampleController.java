package com.qinchy.microservice.provider1.web.nacosconfig;


import com.qinchy.microservice.provider1.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigSampleController {

    @Autowired
    private User user;

    @RequestMapping("/user2")
    public String user() {
        return "[HTTP] " + user;
    }

}
