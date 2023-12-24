package com.exemple.checkbookservice.processor;

import com.exemple.checkbookservice.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
public class CheckBookEventProcessor implements Function<Message<Book>, Message<Book>> {

    @Override
    public Message<Book>  apply(Message<Book> bookMessage) {
        Book raceivedBook = bookMessage.getPayload();
        log.info("raceived book: {} " + raceivedBook);
        return MessageBuilder.withPayload(
                Book.builder()
                        .id(raceivedBook.getId())
                        .name(raceivedBook.getName())
                        .status("checked")
                        .description(raceivedBook.getDescription())
                        .build()
        ).build();
    }
}
