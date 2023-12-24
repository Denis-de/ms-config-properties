package com.exemple.bookservice.controller;

import com.exemple.bookservice.model.Book;
import com.exemple.bookservice.service.BookService;
import com.exemple.bookservice.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookREST {
    private final BookService bookService;

    @Autowired
    public BookREST(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
