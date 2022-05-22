package com.example.library.infra.jpa.entities;

import com.example.library.domain.enums.BookGenreEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="book")
public class BookJPA extends BasicEntityJPA{

    @Column(name = "title")
    protected String title;

    @Column(name="genre")
    @Enumerated(value = EnumType.STRING)
    protected BookGenreEnum genre;

    @Column(name="release_date")
    protected LocalDate releaseDate;

    @ManyToOne
    SectionJPA section;

    @ManyToOne
    protected AuthorJPA author;
}
