package com.example.clientupdate.controller;

import com.example.clientupdate.connector.ClientUpdateConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientUpdateController {

    @Autowired
    private final ClientUpdateConnector updateConnector;

    public ClientUpdateController(ClientUpdateConnector updateConnector) {
        this.updateConnector = updateConnector;
    }

    @GetMapping("/update")
    public String update() {
        return updateConnector.test();
    }
}
