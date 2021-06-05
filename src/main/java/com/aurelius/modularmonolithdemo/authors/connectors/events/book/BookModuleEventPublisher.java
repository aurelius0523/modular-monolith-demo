package com.aurelius.modularmonolithdemo.authors.connectors.events.book;

import com.aurelius.modularmonolithdemo.authors.connectors.events.book.payload.AddBookToAuthorPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BookModuleEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void addBookToAuthor(String authorId, String bookName) {
        applicationEventPublisher.publishEvent(new AddBookToAuthorPayload()
                .setAuthorId(authorId)
                .setBookName(bookName));
    }
}
