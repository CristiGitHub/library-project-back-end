package com.example.library.exposition.IQuerry;

import com.example.library.domain.enums.BookGenreEnum;
import com.example.library.domain.model.Author;
import com.example.library.domain.repository.AuthorsRepository;
import com.example.library.exposition.exception.CustomErrorHandler;
import com.example.library.exposition.exception.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthorIQuerryImpl implements IQuerryAuthors {


    private AuthorsRepository authorsRepository;

    @Override
    public Author getById(String id)  {

        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }

        Optional<Author> authorOptional =  authorsRepository.geyById(id);
        if(authorOptional.isEmpty()){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        else{
            return authorOptional.get();
        }

    }

    @Override
    public BookGenreEnum mostCommonGenre(String id) {
        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        return authorsRepository.mostCommonGenre(id);
    }
}
