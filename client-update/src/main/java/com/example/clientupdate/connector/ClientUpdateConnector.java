package com.example.clientupdate.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client-service")
public interface ClientUpdateConnector {
    @GetMapping("/api/client/test")
    String test();
}
