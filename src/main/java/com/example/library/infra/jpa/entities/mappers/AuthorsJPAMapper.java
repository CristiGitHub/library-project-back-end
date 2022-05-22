package com.example.library.infra.jpa.entities.mappers;

import com.example.library.domain.model.Author;
import com.example.library.exposition.utils.GenericMapper;
import com.example.library.infra.jpa.entities.AuthorJPA;
import com.example.library.infra.jpa.entities.mappers.custom.CutomeMapperUtil;
import com.example.library.infra.jpa.entities.mappers.custom.ListToString;
import com.example.library.infra.jpa.entities.mappers.custom.StringToList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {
                CutomeMapperUtil.class
        }
)
public interface AuthorsJPAMapper extends GenericMapper<Author, AuthorJPA> {
        @Override
        @Mapping(source = "telephone" , target = "telephone" , qualifiedBy = StringToList.class)
        Author toDomain(AuthorJPA authorJPA);

        @Override
        @Mapping(source = "telephone" , target = "telephone" , qualifiedBy = ListToString.class)
        AuthorJPA toDto(Author author);
}
