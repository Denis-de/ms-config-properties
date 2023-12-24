package com.exemple.bookservice.service;

import com.exemple.bookservice.model.Book;
import com.exemple.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> getAllBooks() {
       return bookRepository.findAll();
    }
}
