package com.aurelius.modularmonolithdemo.books.mappers;

import com.aurelius.modularmonolithdemo.commons.dtos.BookDto;
import com.aurelius.modularmonolithdemo.books.repositories.book.entities.BookEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public BookDto fromEntity(BookEntity bookEntity) {
        return new BookDto()
                .setName(bookEntity.getName())
                .setId(bookEntity.getId())
                .setAuthorId(bookEntity.getAuthorId());
    }

    public List<BookDto> fromEntities(List<BookEntity> bookEntityList) {
        if (CollectionUtils.isEmpty(bookEntityList)) {
            return Collections.emptyList();
        }

        return bookEntityList.stream()
                .map((this::fromEntity))
                .collect(Collectors.toList());
    }
}
