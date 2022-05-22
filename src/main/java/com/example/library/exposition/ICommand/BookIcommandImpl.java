package com.example.library.exposition.ICommand;

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
import org.springframework.util.StringUtils;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BookIcommandImpl implements ICommand<Book>{

    private BookRepository bookRepository;

    @Override
    public String save(Book body) {
        verificationBook(body);

        return bookRepository.save(body);
    }

    @Override
    public String update(Book body, String id)  {
        if(body.getId()!=id){
            throw new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }

        return bookRepository.save(body);
    }

    @Override
    public void delete(String id) {
        if(ObjectUtils.isEmpty(id)){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
        bookRepository.delete(id);
    }

    private void verificationBook(Book body){
        if(!StringUtils.hasText(body.getTitle())
                || ObjectUtils.isEmpty(body.getGenre())
                || ObjectUtils.isEmpty(body.getReleaseDate())
        ){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
    }
}
