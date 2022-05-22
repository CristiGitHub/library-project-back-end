package com.example.library.infra.jpa.entities.mappers;

import com.example.library.domain.model.Book;
import com.example.library.exposition.utils.GenericMapper;
import com.example.library.infra.jpa.entities.BookJPA;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                AuthorsJPAMapper.class,
                SectionsJPAMapper.class
        }
)
public interface BookJPAMapper extends GenericMapper<Book, BookJPA> {
}
