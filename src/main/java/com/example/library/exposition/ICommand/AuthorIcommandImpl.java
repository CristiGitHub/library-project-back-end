package com.example.library.exposition.ICommand;

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

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthorIcommandImpl implements ICommand<Author>{

    private AuthorsRepository authorsRepository;

    @Override
    public String save(Author body) {

        fieldVerification(body);

        return authorsRepository.save(body);
    }

    @Override
    public String update(Author body, String id) {

        if(!StringUtils.hasText(id) ||
            !StringUtils.hasText(body.getId()) ||
            !body.getId().equals(id)){
            throw new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }
        fieldVerification(body);

        return authorsRepository.save(body);
    }

    @Override
    public void delete(String id)  {
        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        authorsRepository.delete(id);

    }

    private void fieldVerification(Author body) {
        if(!StringUtils.hasText(body.getFirstName())
                || !StringUtils.hasText(body.getSecondName()))
        {
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
    }
}
