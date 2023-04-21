package com.qinchy.microservice.provider1.config;

import java.io.PrintWriter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;

@Configuration
public class SentinelWebConfig {

    @Bean
    public BlockExceptionHandler sentinelBlockExceptionHandler() {
        return (request, response, e) -> {
            response.setStatus(429);

            PrintWriter out = response.getWriter();
            out.print("Oops, blocked by Sentinel: " + e.getClass().getSimpleName());
            out.flush();
            out.close();
        };
    }
}