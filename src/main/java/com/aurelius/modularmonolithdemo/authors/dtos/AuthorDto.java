package com.aurelius.modularmonolithdemo.authors.dtos;

import com.aurelius.modularmonolithdemo.books.dtos.BookDto;

import java.util.List;

public class AuthorDto {
    private String name;

    public String getName() {
        return name;
    }

    public AuthorDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<BookDto> getBookList() {
        return bookList;
    }

    public AuthorDto setBookList(List<BookDto> bookList) {
        this.bookList = bookList;
        return this;
    }

    private List<BookDto> bookList;

}
