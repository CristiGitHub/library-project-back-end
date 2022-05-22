package com.example.library.infra.jpa.repositorys;

import com.example.library.domain.model.Book;
import com.example.library.domain.repository.BookRepository;
import com.example.library.infra.jpa.entities.BookJPA;
import com.example.library.infra.jpa.entities.mappers.BookJPAMapper;
import com.example.library.infra.jpa.repositorys.jpa.BookJPARepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Repository
public class BookRepositoryImpl implements BookRepository {

    private BookJPAMapper bookJPAMapper;
    private BookJPARepository bookJPARepository;

    @Override
    public String save(Book book) {
        BookJPA bookJPA=bookJPARepository.save(bookJPAMapper.toDto(book));
        return bookJPA.getId();
    }

    @Override
    public void delete(String id)
    {
       bookJPARepository.delete(bookJPARepository.getById(id));
    }

    @Override
    public Optional<Book> getById(String id) {
        Optional<BookJPA> bookOptional = bookJPARepository.findById(id);
        if(bookOptional.isEmpty()){
            return Optional.empty();
        }
        else{
            return Optional.of(bookJPAMapper.toDomain(bookOptional.get()));
        }
    }

    @Override
    public boolean existsById(String id) {
        Optional<BookJPA> bookOptional = bookJPARepository.findById(id);
        if(bookOptional.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
