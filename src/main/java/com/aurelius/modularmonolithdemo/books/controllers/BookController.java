package com.aurelius.modularmonolithdemo.books.controllers;

import com.aurelius.modularmonolithdemo.books.dtos.BookDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public List<BookDto> getBookList(@RequestParam("authorId") String authorId) {
        return Arrays.asList(
                new BookDto().setName("Stormlight Archive" + authorId),
                new BookDto().setName("Oathbringer")
        );
    }
}
