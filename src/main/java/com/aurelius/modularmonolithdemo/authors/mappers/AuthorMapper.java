package com.aurelius.modularmonolithdemo.authors.mappers;

import com.aurelius.modularmonolithdemo.authors.dtos.AuthorDto;
import com.aurelius.modularmonolithdemo.authors.repositories.author.entities.AuthorEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {
    public AuthorDto fromEntity(AuthorEntity authorEntity) {
        return new AuthorDto()
                .setName(authorEntity.getName());

    }

    public List<AuthorDto> fromEntities (List<AuthorEntity> authorEntityList) {
        return authorEntityList
                .stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }
}
