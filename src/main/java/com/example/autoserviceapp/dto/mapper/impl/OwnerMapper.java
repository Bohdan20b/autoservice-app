package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.OwnerRequestDto;
import com.example.autoserviceapp.dto.response.OwnerResponseDto;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.repository.CarRepository;
import com.example.autoserviceapp.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper implements RequestDtoMapper<OwnerRequestDto, Owner>,
        ResponseDtoMapper<OwnerResponseDto, Owner> {
    private final CarRepository carRepository;
    private final OrderRepository orderRepository;

    public OwnerMapper(CarRepository carRepository, OrderRepository orderRepository) {
        this.carRepository = carRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Owner mapToModel(OwnerRequestDto dto) {
        Owner owner = new Owner();
        owner.setCarList(dto.getCarIdList().stream()
                .map(carRepository::getReferenceById)
                .toList());
        owner.setOrderList(dto.getOrderIdList().stream()
                .map(orderRepository::getReferenceById)
                .toList());
        return owner;
    }

    @Override
    public OwnerResponseDto mapToDto(Owner owner) {
        OwnerResponseDto dto = new OwnerResponseDto();
        dto.setId(owner.getId());
        dto.setCarIdList(owner.getCarList().stream()
                .map(Car::getId)
                .toList());
        dto.setOrderIdList(owner.getOrderList().stream()
                .map(Order::getId)
                .toList());
        return dto;
    }
}
