package com.aurelius.modularmonolithdemo.books.repositories.book;

import com.aurelius.modularmonolithdemo.books.repositories.book.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    public List<BookEntity> findByAuthorIdIn(List<Long> authorIdList);
}
