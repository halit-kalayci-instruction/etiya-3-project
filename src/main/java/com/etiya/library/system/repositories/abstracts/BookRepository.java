package com.etiya.library.system.repositories.abstracts;

import com.etiya.library.system.entities.concretes.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
