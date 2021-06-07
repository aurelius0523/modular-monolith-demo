package com.aurelius.modularmonolithdemo.authors.controllers;

import com.aurelius.modularmonolithdemo.authors.dtos.AuthorDto;
import com.aurelius.modularmonolithdemo.authors.facades.AuthorFacade;
import com.aurelius.modularmonolithdemo.authors.repositories.author.AuthorRepository;
import com.aurelius.modularmonolithdemo.authors.repositories.author.entities.AuthorEntity;
import com.aurelius.modularmonolithdemo.books.respositories.book.BookRepository;
import com.aurelius.modularmonolithdemo.books.respositories.book.BookRepositoryConfig;
import com.aurelius.modularmonolithdemo.books.respositories.book.entities.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorFacade authorFacade;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<AuthorDto> getAuthorList() {
        authorRepository.findAll()
                .stream()
                .map(AuthorEntity::getName)
                .forEach(System.out::println);

        bookRepository.findAll()
                .stream()
                .map(BookEntity::getName)
                .forEach(System.out::println);

        return authorFacade.getAuthorList();
    }

    @PostMapping("/books")
    public AuthorDto addBookToAuthor() {
        return authorFacade.addBookToAuthor();
    }
}
