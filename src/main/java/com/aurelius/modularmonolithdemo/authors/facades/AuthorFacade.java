package com.aurelius.modularmonolithdemo.authors.facades;

import com.aurelius.modularmonolithdemo.authors.connectors.events.book.BookModuleEventPublisher;
import com.aurelius.modularmonolithdemo.authors.connectors.feign.book.BookClient;
import com.aurelius.modularmonolithdemo.authors.dtos.AuthorDto;
import com.aurelius.modularmonolithdemo.authors.mappers.AuthorMapper;
import com.aurelius.modularmonolithdemo.authors.repositories.author.AuthorRepository;
import com.aurelius.modularmonolithdemo.authors.repositories.author.entities.AuthorEntity;
import com.aurelius.modularmonolithdemo.books.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorFacade {
    @Autowired
    private BookClient bookClient;

    @Autowired
    BookModuleEventPublisher bookModuleEventPublisher;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDto> getAuthorList() {
        List<AuthorEntity> authorEntityList = authorRepository.findAll();
        List<String> authorIdList = authorEntityList.stream()
                .map(authorEntity -> String.valueOf(authorEntity.getId()))
                .collect(Collectors.toList());

        List<BookDto> bookDtoList = bookClient.getBookList(authorIdList);
        return authorMapper.fromEntities(authorEntityList);
    }


    public AuthorDto addBookToAuthor() {
        bookModuleEventPublisher.addBookToAuthor("brandon", "cool book");
        return new AuthorDto();
    }
}
