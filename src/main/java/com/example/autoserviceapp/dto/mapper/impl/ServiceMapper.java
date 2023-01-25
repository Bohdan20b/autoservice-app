package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.ServiceRequestDto;
import com.example.autoserviceapp.dto.response.ServiceResponseDto;
import com.example.autoserviceapp.model.ServiceObject;
import com.example.autoserviceapp.repository.MasterRepository;
import com.example.autoserviceapp.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper implements RequestDtoMapper<ServiceRequestDto, ServiceObject>,
        ResponseDtoMapper<ServiceResponseDto, ServiceObject> {
    private final OrderRepository orderRepository;
    private final MasterRepository masterRepository;

    public ServiceMapper(OrderRepository orderRepository, MasterRepository masterRepository) {
        this.orderRepository = orderRepository;
        this.masterRepository = masterRepository;
    }

    @Override
    public ServiceObject mapToModel(ServiceRequestDto dto) {
        ServiceObject service = new ServiceObject();
        service.setOrder(orderRepository.getReferenceById(dto.getOrderId()));
        service.setMaster(masterRepository.getReferenceById(dto.getMasterId()));
        service.setPrice(dto.getPrice());
        service.setStatus(dto.getStatus());
        return service;
    }

    @Override
    public ServiceResponseDto mapToDto(ServiceObject serviceObject) {
        ServiceResponseDto dto = new ServiceResponseDto();
        dto.setId(serviceObject.getId());
        dto.setOrderId(serviceObject.getOrder().getId());
        dto.setStatus(serviceObject.getStatus());
        dto.setMasterId(serviceObject.getMaster().getId());
        dto.setPrice(serviceObject.getPrice());
        return dto;
    }
}
