package com.aurelius.modularmonolithdemo.books.controllers;

import com.aurelius.modularmonolithdemo.commons.dtos.BookDto;
import com.aurelius.modularmonolithdemo.books.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookFacade bookFacade;

    @GetMapping
    public List<BookDto> getBookList(@RequestParam("authorIdList") List<String> authorIdList) {
        return bookFacade.getBookList(authorIdList);
    }
}
