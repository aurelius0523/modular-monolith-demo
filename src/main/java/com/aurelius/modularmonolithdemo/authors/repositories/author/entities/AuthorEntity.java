package com.aurelius.modularmonolithdemo.authors.repositories.author.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public AuthorEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorEntity setName(String name) {
        this.name = name;
        return this;
    }
}
