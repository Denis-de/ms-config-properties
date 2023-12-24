package com.exemple.configclient.service;

import com.exemple.configclient.connector.BookServiceConnector;
import com.exemple.configclient.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final BookServiceConnector bookServiceConnector;

    public ClientServiceImpl(BookServiceConnector bookServiceConnector) {
        this.bookServiceConnector = bookServiceConnector;
    }

    @Override
    public List<Book> getAllBooks(){
        return bookServiceConnector.getAllBooks();
    }

}
