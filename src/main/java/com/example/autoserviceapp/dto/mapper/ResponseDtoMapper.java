package com.example.autoserviceapp.dto.mapper;

public interface ResponseDtoMapper<D, M> {
    D mapToDto(M m);
}
