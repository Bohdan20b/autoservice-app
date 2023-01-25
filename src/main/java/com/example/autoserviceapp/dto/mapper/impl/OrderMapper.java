package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.OrderRequestDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.Commodity;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.ServiceObject;
import com.example.autoserviceapp.repository.CommodityRepository;
import com.example.autoserviceapp.repository.ServiceRepository;
import com.example.autoserviceapp.service.CarService;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements RequestDtoMapper<OrderRequestDto, Order>,
        ResponseDtoMapper<OrderResponseDto, Order> {
    private final ServiceRepository serviceRepository;
    private final CommodityRepository commodityRepository;
    private final CarService carService;

    public OrderMapper(ServiceRepository serviceRepository, CommodityRepository commodityRepository,
            CarService carService) {
        this.serviceRepository = serviceRepository;
        this.commodityRepository = commodityRepository;
        this.carService = carService;
    }

    @Override
    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setCar(carService.get(dto.getCarId()));
        order.setProblem(dto.getProblem());
        order.setServiceList(dto.getServiceIdList().stream()
                .map(serviceRepository::getReferenceById)
                .toList());
        order.setCommodityList(dto.getCommodityIdList().stream()
                .map(commodityRepository::getReferenceById)
                .toList());
        order.setStatus(dto.getStatus());
        order.setPrice(dto.getPrice());
        return order;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setCarId(order.getCar().getId());
        dto.setProblem(order.getProblem());
        dto.setAcceptTime(order.getAcceptTime());
        dto.setServiceIdList(order.getServiceList().stream()
                .map(ServiceObject::getId)
                .toList());
        dto.setCommodityIdList(order.getCommodityList().stream()
                .map(Commodity::getId)
                .toList());
        dto.setStatus(order.getStatus());
        dto.setPrice(order.getPrice());
        dto.setCompleteTime(order.getCompleteTime());
        return dto;
    }
}
