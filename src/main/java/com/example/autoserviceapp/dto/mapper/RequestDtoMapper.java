package com.example.autoserviceapp.dto.mapper;

public interface RequestDtoMapper<D, M> {
    M mapToModel(D dto);
}
