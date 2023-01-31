package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.CommodityRequestDto;
import com.example.autoserviceapp.dto.request.OrderRequestDto;
import com.example.autoserviceapp.dto.request.StatusRequestDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.Commodity;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Order.Status;
import com.example.autoserviceapp.service.OrderService;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final RequestDtoMapper<OrderRequestDto, Order> orderRequestMapper;
    private final ResponseDtoMapper<OrderResponseDto, Order> orderResponseMapper;
    private final RequestDtoMapper<CommodityRequestDto, Commodity> commodityRequestMapper;
    private final RequestDtoMapper<StatusRequestDto, Order.Status> statusRequestMapper;

    public OrderController(OrderService orderService,
            RequestDtoMapper<OrderRequestDto, Order> orderRequestMapper,
            ResponseDtoMapper<OrderResponseDto, Order> orderResponseMapper,
            RequestDtoMapper<CommodityRequestDto, Commodity> commodityRequestMapper,
            RequestDtoMapper<StatusRequestDto, Status> statusRequestMapper) {
        this.orderService = orderService;
        this.orderRequestMapper = orderRequestMapper;
        this.orderResponseMapper = orderResponseMapper;
        this.commodityRequestMapper = commodityRequestMapper;
        this.statusRequestMapper = statusRequestMapper;
    }

    @PostMapping
    @ApiOperation("Create new order")
    public OrderResponseDto create(@RequestBody OrderRequestDto dto) {
        Order order = orderRequestMapper.mapToModel(dto);
        return orderResponseMapper.mapToDto(orderService.add(order));
    }

    @PostMapping("/{id}")
    @ApiOperation("Update order by id")
    public OrderResponseDto update(@PathVariable Long id, @RequestBody OrderRequestDto dto) {
        Order order = orderRequestMapper.mapToModel(dto);
        order.setId(id);
        return orderResponseMapper.mapToDto(orderService.update(order));
    }

    @PostMapping("/{id}/commodity")
    @ApiOperation("Add new commodity to the order by order id")
    public OrderResponseDto addCommodityByOrderId(@PathVariable Long id,
            @RequestBody CommodityRequestDto dto) {
        Commodity commodity = commodityRequestMapper.mapToModel(dto);
        return orderResponseMapper.mapToDto(orderService.addCommodity(id, commodity));
    }

    @GetMapping("/{id}/update-status")
    @ApiOperation("Update the order status by order id")
    public OrderResponseDto updateStatus(@PathVariable Long id,
            @RequestBody StatusRequestDto dto) {
        Order.Status status = statusRequestMapper.mapToModel(dto);
        return orderResponseMapper.mapToDto(orderService.updateStatus(id, status));
    }

    @GetMapping("/{id}/price")
    @ApiOperation("Get total price by order id")
    public BigDecimal countPrice(@PathVariable Long id) {
        return orderService.countPrice(id);
    }
}
