package com.example.library.infra.jpa.repositorys;

import com.example.library.domain.enums.BookGenreEnum;
import com.example.library.domain.model.Author;
import com.example.library.domain.repository.AuthorsRepository;
import com.example.library.exposition.exception.CustomErrorHandler;
import com.example.library.exposition.exception.ExceptionEnum;
import com.example.library.infra.jpa.entities.AuthorJPA;
import com.example.library.infra.jpa.entities.BookJPA;
import com.example.library.infra.jpa.entities.mappers.AuthorsJPAMapper;
import com.example.library.infra.jpa.repositorys.jpa.AuthorsJPARepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Repository
public class AuthorsRepositoryImpl implements AuthorsRepository {

    private AuthorsJPARepository authorsJPARepository;
    private AuthorsJPAMapper authorsJPAMapper;
    @Override
    public String save(Author author) {
        AuthorJPA authorJPA = authorsJPARepository.save(authorsJPAMapper.toDto(author));
        return  authorJPA.getId();
    }

    @Override
    public void delete(String id) {
        authorsJPARepository.delete(authorsJPARepository.getById(id));

    }

    @Override
    public BookGenreEnum mostCommonGenre(String id){

        AuthorJPA authorJPAOptional = authorsJPARepository.getById(id);


        Map<BookGenreEnum,Long> map = authorJPAOptional.getBook().stream()
                .map(BookJPA::getGenre)
                .collect(
                        Collectors.groupingBy(e->e , Collectors.counting()));
        Long biggestValue = map.values().stream().max(Long::compareTo).get();
        Long count = map.values().stream().filter(e->e==biggestValue).count();
        if(count>1){
            return BookGenreEnum.INVALID;
        }
        else{
            for(var items : map.entrySet()){
                if(items.getValue()==biggestValue){
                    return items.getKey();
                }
            }
        }
        return BookGenreEnum.INVALID;
    }

    @Override
    public Optional<Author> geyById(String id) {

       Optional<AuthorJPA> authorsJPAOptional = authorsJPARepository.findById(id);
       if(authorsJPAOptional.isEmpty())
       {
           return Optional.empty();
       }
       else{
           return Optional.of(authorsJPAMapper.toDomain(authorsJPAOptional.get()));
       }
    }

    @Override
    public boolean existsById(String id) {
        Optional<AuthorJPA> authorsJPAOptional = authorsJPARepository.findById(id);
       if(authorsJPAOptional.isEmpty()){
           return false;
       }
       else {
           return true;
       }
    }
}
