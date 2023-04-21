package com.qinchy.microservice.provider1.web.nacosdiscover;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoServiceController {

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {
        return "[ECHO] : " + message;
    }
}
