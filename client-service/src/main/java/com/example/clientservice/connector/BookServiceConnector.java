package com.example.clientservice.connector;

import com.example.clientservice.model.Book;
import feign.Feign;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Collections;
import java.util.List;
/*@FeignClient(name = "book-service")
@CircuitBreaker(name = "book-service", fallbackMethod = "fallback")
public interface BookServiceConnector {
    @GetMapping("/api/books")
    List<Book> getAllBooks();

    default List<Book> fallback(Throwable ex) {
        final Logger log = LogManager.getLogger(Feign.class);
        log.info( ex.getMessage());
        return Collections.emptyList();
    }
}**/
@FeignClient(name = "book-service", fallbackFactory = BookServiceConnectorFallbackFactory.class

)


public interface BookServiceConnector {

    @GetMapping("/api/books")
    List<Book> getAllBooks();
}


@Component
class BookServiceConnectorFallbackFactory implements FallbackFactory<FallbackWithFactory> {

    @Override
    public FallbackWithFactory create(Throwable cause) {
        return new FallbackWithFactory(cause.getMessage());
    }
}

@Slf4j
record FallbackWithFactory(String reason) implements BookServiceConnector {
    @Override
    public List<Book> getAllBooks() {
        log.info("Failed send request on book service, reason {}", reason);
        return Collections.emptyList();
    }
}