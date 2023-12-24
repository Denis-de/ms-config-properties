package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    private final BookServiceConnector bookServiceConnector;

    public ClientServiceImpl(BookServiceConnector bookServiceConnector) {
        this.bookServiceConnector = bookServiceConnector;
    }

    @Override
    public List<Book> getAllBooks(){
        return bookServiceConnector.getAllBooks();
    }
}
