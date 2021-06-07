package com.aurelius.modularmonolithdemo.books.respositories.book.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author_id")
    private Long authorId;

    public Long getId() {
        return id;
    }

    public BookEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public BookEntity setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }
}
