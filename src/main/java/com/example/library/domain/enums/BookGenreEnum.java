package com.example.library.domain.enums;

import lombok.Getter;

@Getter
public enum BookGenreEnum {

    SC_FI("Sc-Fi"),
    DRAMA("Drama"),
    ACTION("Actiune"),
    ADVENTURE("Aventura"),
    CRIME("Politiste"),
    INVALID("Invalid");


    private String label;

    BookGenreEnum(String label) {
        this.label = label;
    }
}
