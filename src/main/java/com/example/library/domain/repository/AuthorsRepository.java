package com.example.library.domain.repository;

import com.example.library.domain.enums.BookGenreEnum;
import com.example.library.domain.model.Author;
import com.example.library.exposition.exception.CustomErrorHandler;

import java.util.Optional;

public interface AuthorsRepository {

    String save(Author author);

    void delete(String id);

    BookGenreEnum mostCommonGenre(String id);

    Optional<Author> geyById(String id);

    boolean existsById(String id);

}
