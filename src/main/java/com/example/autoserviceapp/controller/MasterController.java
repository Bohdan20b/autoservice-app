package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.MasterRequestDto;
import com.example.autoserviceapp.dto.response.MasterResponseDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.service.MasterService;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masters")
public class MasterController {
    private final MasterService masterService;
    private final RequestDtoMapper<MasterRequestDto, Master> requestDtoMapper;
    private final ResponseDtoMapper<MasterResponseDto, Master> responseDtoMapper;
    private final ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper;

    public MasterController(MasterService masterService,
            RequestDtoMapper<MasterRequestDto, Master> requestDtoMapper,
            ResponseDtoMapper<MasterResponseDto, Master> responseDtoMapper,
            ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper) {
        this.masterService = masterService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
    }

    @PostMapping
    @ApiOperation("Create a new master")
    public MasterResponseDto create(@RequestBody MasterRequestDto dto) {
        Master master = masterService.add(requestDtoMapper.mapToModel(dto));
        return responseDtoMapper.mapToDto(master);
    }

    @PostMapping("/{id}")
    @ApiOperation("Update master by id")
    public MasterResponseDto update(@PathVariable Long id, @RequestBody MasterRequestDto dto) {
        Master master = requestDtoMapper.mapToModel(dto);
        master.setId(id);
        return responseDtoMapper.mapToDto(masterService.update(master));
    }

    @GetMapping("{id}/orders-by-id/")
    @ApiOperation("Get all orders by masters id")
    public List<OrderResponseDto> getAllOrdersByMasterId(@PathVariable Long id) {
        return masterService.getOrdersList(id).stream()
                .map(orderResponseDtoMapper::mapToDto)
                .toList();
    }

    @GetMapping("{id}/salary-by-id/")
    @ApiOperation("Get salary for master by id")
    public BigDecimal countSalary(@PathVariable Long id) {
        return masterService.countSalary(id);
    }
}
