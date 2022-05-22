package com.example.library.exposition.IQuerry;

import com.example.library.domain.enums.BookGenreEnum;
import com.example.library.domain.model.Author;
import com.example.library.exposition.exception.CustomErrorHandler;

public interface IQuerryAuthors extends IQuerry<Author> {

    BookGenreEnum mostCommonGenre(String id) ;

}
