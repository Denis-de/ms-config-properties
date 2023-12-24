package com.exemle.creationbookservice.config;

import com.exemle.creationbookservice.model.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.LinkedList;

@Configuration
@EnableScheduling
public class ConfigEventSource {
    public LinkedList<Book> createBookCreationEventSource() {
        return new LinkedList<>();
    }
}
