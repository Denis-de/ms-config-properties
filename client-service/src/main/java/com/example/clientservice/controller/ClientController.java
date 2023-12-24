package com.example.clientservice.controller;

import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.getProperty;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;
    private Environment env;

    private static final Logger LOG = Logger.getLogger(ClientController.class.getName());
    @RequestMapping("/")
    public String home() {
        String home = "Client-Service running at port: " + env.getProperty("local.server.port");
        LOG.log(Level.INFO, home);

        return home;
    }

    @Value("${eureka.instance.instance-id}")
    private String id;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooksFromClient() {
        return clientService.getAllBooks();
    }

    @GetMapping("/test")
    public String test() {
        return id;
    }
}
