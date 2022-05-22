package com.example.library.domain.repository;

import com.example.library.domain.model.Book;

import java.util.Optional;

public interface BookRepository {
    String save(Book book);
    void delete(String id);
    Optional<Book> getById(String id);

    boolean existsById(String id);
}
