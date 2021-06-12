package com.aurelius.modularmonolithdemo.books.facades;

import com.aurelius.modularmonolithdemo.authors.connectors.events.book.payload.AddBookToAuthorPayload;
import com.aurelius.modularmonolithdemo.books.dtos.BookDto;
import com.aurelius.modularmonolithdemo.books.mappers.BookMapper;
import com.aurelius.modularmonolithdemo.books.repositories.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookFacade {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDto> getBookList(List<String> authorIdList) {
        if (CollectionUtils.isEmpty(authorIdList)) {
            return bookMapper.fromEntities(bookRepository.findAll());
        }

        return bookMapper.fromEntities(bookRepository.findByAuthorIdIn(authorIdList
                .stream()
                .map(Long::valueOf)
                .collect(Collectors.toList())));
    }

    @EventListener
    public void addBookToAuthor(AddBookToAuthorPayload addBookToAuthorPayload) {
        System.out.println(addBookToAuthorPayload.getAuthorId() + ":" + addBookToAuthorPayload.getBookName());
    }
}
