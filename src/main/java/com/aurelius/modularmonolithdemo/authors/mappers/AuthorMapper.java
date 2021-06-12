package com.aurelius.modularmonolithdemo.authors.mappers;

import com.aurelius.modularmonolithdemo.authors.dtos.AuthorDto;
import com.aurelius.modularmonolithdemo.authors.repositories.author.entities.AuthorEntity;
import com.aurelius.modularmonolithdemo.books.dtos.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {
    public AuthorDto fromEntity(AuthorEntity authorEntity) {
        return new AuthorDto()
                .setName(authorEntity.getName())
                .setId(authorEntity.getId());

    }

    public List<AuthorDto> fromEntities(List<AuthorEntity> authorEntityList) {
        return authorEntityList
                .stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    public List<AuthorDto> fromBookEntities(List<AuthorDto> authorDtoList, List<BookDto> bookDtoList) {
        return authorDtoList.stream()
                .map(authorDto -> {
                    authorDto.setBookList(bookDtoList.stream()
                            .filter(bookDto -> bookDto.getAuthorId().equals(authorDto.getId()) )
                            .collect(Collectors.toList()));

                    return authorDto;
                })
                .collect(Collectors.toList());
    }
}
