package com.aurelius.modularmonolithdemo.authors.controllers;

import com.aurelius.modularmonolithdemo.authors.dtos.AuthorDto;
import com.aurelius.modularmonolithdemo.authors.facades.AuthorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorFacade authorFacade;

    @GetMapping
    public List<AuthorDto> getAuthorList() {
        return authorFacade.getAuthorList();
    }
}
