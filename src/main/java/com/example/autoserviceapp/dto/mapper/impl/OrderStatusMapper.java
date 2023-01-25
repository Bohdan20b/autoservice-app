package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.request.StatusRequestDto;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Order.Status;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusMapper implements RequestDtoMapper<StatusRequestDto, Order.Status> {

    @Override
    public Status mapToModel(StatusRequestDto dto) {
        return Status.valueOf(dto.getName());
    }
}
