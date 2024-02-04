package com.exemple.configclient.service;

import com.exemple.configclient.connector.BookServiceConnector;
import com.exemple.configclient.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigClientImpl implements ConfigClient {
    private final BookServiceConnector bookServiceConnector;

    public ConfigClientImpl(BookServiceConnector bookServiceConnector) {
        this.bookServiceConnector = bookServiceConnector;
    }

    @Override
    public List<Book> getAllBooks(){
        return bookServiceConnector.getAllBooks();
    }

}
