package com.aurelius.modularmonolithdemo.commons.dtos;

import java.util.List;

public class AuthorDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public AuthorDto setId(Long id) {
        this.id = id;
        return this;
    }

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
