package com.example.library.infra.jpa.repositorys.jpa;

import com.example.library.infra.jpa.entities.BookJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJPARepository extends JpaRepository<BookJPA,String> {
}
