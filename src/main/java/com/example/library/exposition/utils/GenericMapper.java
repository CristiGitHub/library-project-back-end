package com.example.library.exposition.utils;


public interface GenericMapper<Domain,DTO> {

DTO toDto(Domain domain);

Domain toDomain(DTO dto);

}
