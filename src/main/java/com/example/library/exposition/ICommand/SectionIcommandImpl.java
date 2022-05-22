package com.example.library.exposition.ICommand;

import com.example.library.domain.model.Section;
import com.example.library.domain.repository.SectionRepository;
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
public class SectionIcommandImpl implements ICommand<Section> {

    private SectionRepository sectionRepository;

    @Override
    public String save(Section body) {
        if(!StringUtils.hasText(body.getLabel())){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
        return sectionRepository.save(body);
    }

    @Override
    public String update(Section body, String id)  {
        if(!StringUtils.hasText(id) ||
            !StringUtils.hasText(body.getId()) ||
            !id.equals(body.getId())){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        if(!sectionRepository.existsById(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        if(!StringUtils.hasText(body.getLabel())){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }

       return sectionRepository.save(body);
    }

    @Override
    public void delete(String id)  {
        if(!StringUtils.hasText(id) || !sectionRepository.existsById(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        sectionRepository.delete(id);
    }
}
