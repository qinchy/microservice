package com.qinchy.microservice.provider1.service.dubbo;

public interface FooService {

    String sayHello(String name);

    long getCurrentTime(boolean slow);
}
