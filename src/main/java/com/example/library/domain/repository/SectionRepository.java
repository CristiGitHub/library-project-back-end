package com.example.library.domain.repository;

import com.example.library.domain.model.Section;

import java.util.Optional;

public interface SectionRepository {

    String save(Section section);

    void delete(String id);

    Optional<Section> getById(String id);

    boolean existsById(String id);
}
