package com.example.library.exposition.exception;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    EMPTY_FIELD("Some of the fields were incomplete","error_empty_field"),
    INVALID_FIELD("One or more fields are invalid", "error_invalid_id"),
    OBJECT_NOT_FOUND("The object couldn't be found", "error_object_not_found")


    ;

    ExceptionEnum(String error_message, String error_key) {
        this.error_message = error_message;
        this.error_key = error_key;
    }

    private String error_message;
    private String error_key;
}
