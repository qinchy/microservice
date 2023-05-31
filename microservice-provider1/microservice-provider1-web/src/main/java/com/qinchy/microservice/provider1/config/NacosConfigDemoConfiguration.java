package com.qinchy.microservice.provider1.config;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;

@Configuration
@EnableConfigurationProperties(User.class)
public class NacosConfigDemoConfiguration {

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @Autowired
    private User user;

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int userAge;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            String dataId = "microservice-provider1.yaml";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("[Listener] " + configInfo);
                    System.out.println("[Before User] " + user);

                    Properties properties = new Properties();
                    try {
                        properties.load(new StringReader(configInfo));
                        String name = properties.getProperty("user.name");
                        int age = Integer.valueOf(properties.getProperty("user.age"));
                        user.setName(name);
                        user.setAge(age);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[After User] " + user);
                }
            });
        };
    }


    @PostConstruct
    public void init() {
        System.out.printf("[init] user name : %s , age : %d%n", userName, userAge);
    }

    @PreDestroy
    public void destroy() {
        System.out.printf("[destroy] user name : %s , age : %d%n", userName, userAge);
    }
}
