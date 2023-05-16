package com.etiya.library.system.repositories.abstracts;

import com.etiya.library.system.entities.concretes.Author;
import com.etiya.library.system.entities.concretes.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // JPA derived query methods
    Author findByNationalityId(String nationalityId);
}

