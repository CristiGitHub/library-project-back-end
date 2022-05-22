package com.example.library.infra.jpa.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Sections")
@Table(name="sections")
public class SectionJPA extends BasicEntityJPA{

    @Column(name="label")
    private String label;



    @OneToMany(mappedBy = "section")
    Set<BookJPA> books = new HashSet<>();



}
