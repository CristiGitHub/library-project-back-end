package com.example.library.domain.model;

import lombok.*;
import org.hibernate.dialect.AbstractHANADialect;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    String id;
    String firstName;
    String secondName;
    boolean isAlive;
    LocalDate birthday;
    List<String> telephone;
    Set<Book> book = new HashSet<>();

}
