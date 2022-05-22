package com.example.library.infra.jpa.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Authors")
@Table(name="authors")
public class AuthorJPA extends BasicEntityJPA{

    @Column(name="firstname")
    private String firstName;

    @Column(name="secondname")
    private String secondName;

    @Column(name="isAlive")
    private boolean isAlive;

    @Column(name="birthday")
    private LocalDate birthday;

    @Column(name="telephone_numbers")
    private String telephone;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL, orphanRemoval = true)
    Set<BookJPA> book = new HashSet<>();

}
