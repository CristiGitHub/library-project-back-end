package com.example.library.exposition.IQuerry;

import com.example.library.domain.model.Book;
import com.example.library.domain.repository.BookRepository;
import com.example.library.exposition.exception.CustomErrorHandler;
import com.example.library.exposition.exception.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BookIQuerryImpl implements IQuerry<Book> {

    private BookRepository bookRepository;

    @Override
    public Book getById(String id) {

        if (ObjectUtils.isEmpty(id)) {
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }

        Optional<Book> bookOptional = bookRepository.getById(id);

        if (bookOptional.isEmpty()) {
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }

        return bookOptional.get();
    }
}
