package com.example.library.infra.jpa.repositorys;

import com.example.library.domain.model.Section;
import com.example.library.domain.repository.SectionRepository;
import com.example.library.infra.jpa.entities.SectionJPA;
import com.example.library.infra.jpa.entities.mappers.SectionsJPAMapper;
import com.example.library.infra.jpa.repositorys.jpa.SectionJPARepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Repository
public class SectionRepositoryImpl implements SectionRepository {

    private SectionJPARepository sectionJPARepository;
    private SectionsJPAMapper sectionsJPAMapper;

    @Override
    public String save(Section section) {
       return sectionJPARepository.save(sectionsJPAMapper.toDto(section)).getId();
    }

    @Override
    public void delete(String id) {
        sectionJPARepository.delete(sectionJPARepository.getById(id));
    }

    @Override
    public Optional<Section> getById(String id) {
        Optional<SectionJPA> sectionJPAOptional = sectionJPARepository.findById(id);
        if(sectionJPAOptional.isEmpty()){
            return Optional.empty();
        }
        else {
            return Optional.of(sectionsJPAMapper.toDomain(sectionJPAOptional.get()));
        }
    }

    @Override
    public boolean existsById(String id) {
        Optional<SectionJPA> sectionJPAOptional = sectionJPARepository.findById(id);
        if(sectionJPAOptional.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

}
