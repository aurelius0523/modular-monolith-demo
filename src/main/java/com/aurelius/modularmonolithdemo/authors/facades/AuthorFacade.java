package com.aurelius.modularmonolithdemo.authors.facades;

import com.aurelius.modularmonolithdemo.authors.connectors.events.book.BookModuleEventPublisher;
import com.aurelius.modularmonolithdemo.authors.connectors.feign.book.BookClient;
import com.aurelius.modularmonolithdemo.authors.dtos.AuthorDto;
import com.aurelius.modularmonolithdemo.books.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorFacade {
    @Autowired
    private BookClient bookClient;

    @Autowired
    BookModuleEventPublisher bookModuleEventPublisher;

    public List<AuthorDto> getAuthorList() {
        bookClient.getBookList("123")
                .stream()
                .map(BookDto::getName)
                .forEach(System.out::println);

        return new ArrayList<>();
    }

    public AuthorDto addBookToAuthor() {
        bookModuleEventPublisher.addBookToAuthor("brandon", "cool book");
        return new AuthorDto();
    }
}
