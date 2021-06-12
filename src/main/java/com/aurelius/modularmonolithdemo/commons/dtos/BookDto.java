package com.aurelius.modularmonolithdemo.commons.dtos;

public class BookDto {
    private Long id;
    private String name;
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }

    public BookDto setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public BookDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookDto setName(String name) {
        this.name = name;
        return this;
    }
}
