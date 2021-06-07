package com.aurelius.modularmonolithdemo.authors.repositories.author;

import com.aurelius.modularmonolithdemo.authors.repositories.author.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
