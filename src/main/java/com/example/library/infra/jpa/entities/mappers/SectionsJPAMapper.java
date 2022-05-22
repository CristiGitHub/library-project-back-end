package com.example.library.infra.jpa.entities.mappers;

import com.example.library.domain.model.Section;
import com.example.library.exposition.utils.GenericMapper;
import com.example.library.infra.jpa.entities.SectionJPA;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface SectionsJPAMapper extends GenericMapper<Section, SectionJPA> {
}
