package com.example.library.exposition.IQuerry;

import com.example.library.domain.model.Book;
import com.example.library.domain.model.Section;
import com.example.library.domain.repository.SectionRepository;
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
public class SectionIQuerryImpl implements IQuerry<Section> {

    private SectionRepository sectionRepository;

    @Override
    public Section getById(String id)  {
        if (ObjectUtils.isEmpty(id)) {
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }

        Optional<Section> sectionOptional = sectionRepository.getById(id);

        if (sectionOptional.isEmpty()) {
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }

        return sectionOptional.get();
    }
}
