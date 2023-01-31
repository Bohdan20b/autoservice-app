package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.MasterRequestDto;
import com.example.autoserviceapp.dto.response.MasterResponseDto;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class MasterMapper implements RequestDtoMapper<MasterRequestDto, Master>,
        ResponseDtoMapper<MasterResponseDto, Master> {

    private final OrderRepository repository;

    public MasterMapper(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Master mapToModel(MasterRequestDto dto) {
        Master master = new Master();
        master.setName(dto.getName());
        master.setCompleteOrders(dto.getCompleteOrders().stream()
                .map(repository::getReferenceById)
                .toList());
        return master;
    }

    @Override
    public MasterResponseDto mapToDto(Master master) {
        MasterResponseDto dto = new MasterResponseDto();
        dto.setId(master.getId());
        dto.setName(master.getName());
        dto.setCompleteOrdersId(master.getCompleteOrders().stream()
                .map(Order::getId)
                .toList());
        return dto;
    }
}
