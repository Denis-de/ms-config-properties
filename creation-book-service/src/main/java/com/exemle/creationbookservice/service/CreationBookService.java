package com.exemle.creationbookservice.service;

import com.exemle.creationbookservice.model.Book;
import com.exemle.creationbookservice.util.BookGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
@AllArgsConstructor
@Slf4j
public class CreationBookService {
    private final LinkedList<Book> bookCreationEvents;
    private final BookGenerator bookGenerator;

    @Scheduled(fixedRate = 10000)
    public void generateBooks() {
        Book book = bookGenerator.createNewBook();
        bookCreationEvents.add(book);
    }
}
