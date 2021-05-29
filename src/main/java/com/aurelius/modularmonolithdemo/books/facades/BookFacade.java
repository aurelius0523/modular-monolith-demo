package com.aurelius.modularmonolithdemo.books.facades;

import com.aurelius.modularmonolithdemo.authors.connectors.events.book.payload.AddBookToAuthorPayload;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookFacade {
    @EventListener
    public void addBookToAuthor(AddBookToAuthorPayload addBookToAuthorPayload) {
        System.out.println(addBookToAuthorPayload.getAuthorId() + ":" + addBookToAuthorPayload.getBookName());
    }
}
