package com.example.library.domain.model;

import com.example.library.domain.enums.BookGenreEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    String id;
    String title;
    BookGenreEnum genre;
    LocalDate releaseDate;
    Section section;
    Author author;
}
