package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.OwnerRequestDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.dto.response.OwnerResponseDto;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.service.OwnerService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final RequestDtoMapper<OwnerRequestDto, Owner> ownerRequestMapper;
    private final ResponseDtoMapper<OwnerResponseDto, Owner> onwerResponseMapper;
    private final ResponseDtoMapper<OrderResponseDto, Order> orderResponseMapper;

    public OwnerController(OwnerService ownerService,
            RequestDtoMapper<OwnerRequestDto, Owner> ownerRequestMapper,
            ResponseDtoMapper<OwnerResponseDto, Owner> onwerResponseMapper,
            ResponseDtoMapper<OrderResponseDto, Order> orderResponseMapper) {
        this.ownerService = ownerService;
        this.ownerRequestMapper = ownerRequestMapper;
        this.onwerResponseMapper = onwerResponseMapper;
        this.orderResponseMapper = orderResponseMapper;
    }

    @PostMapping
    public OwnerResponseDto create(@RequestBody OwnerRequestDto dto) {
        Owner owner = ownerService.add(ownerRequestMapper.mapToModel(dto));
        return onwerResponseMapper.mapToDto(owner);
    }

    @PostMapping("/{id}")
    public OwnerResponseDto update(@PathVariable Long id, @RequestBody OwnerRequestDto dto) {
        Owner owner = ownerRequestMapper.mapToModel(dto);
        owner.setId(id);
        return onwerResponseMapper.mapToDto(owner);
    }

    @PostMapping("/{id}/orders")
    public List<OrderResponseDto> getAllOrdersByOwnerId(@PathVariable Long id) {
        return ownerService.getOrdersList(id).stream()
                .map(orderResponseMapper::mapToDto)
                .toList();
    }
}
