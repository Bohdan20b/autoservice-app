package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.CommodityRequestDto;
import com.example.autoserviceapp.dto.response.CommodityResponseDto;
import com.example.autoserviceapp.model.Commodity;
import com.example.autoserviceapp.service.CommodityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commodities")
public class CommodityController {
    private final CommodityService commodityService;
    private final RequestDtoMapper<CommodityRequestDto, Commodity> requestMapper;
    private final ResponseDtoMapper<CommodityResponseDto, Commodity> responseMapper;

    public CommodityController(CommodityService commodityService,
            RequestDtoMapper<CommodityRequestDto, Commodity> requestMapper,
            ResponseDtoMapper<CommodityResponseDto, Commodity> responseMapper) {
        this.commodityService = commodityService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    @ApiOperation("Create a new commodity")
    public CommodityResponseDto create(@RequestBody CommodityRequestDto dto) {
        Commodity commodity = commodityService.add(requestMapper.mapToModel(dto));
        return responseMapper.mapToDto(commodity);
    }

    @PostMapping("/{id}")
    @ApiOperation("Update commodity by id")
    public CommodityResponseDto update(@PathVariable Long id,
            @RequestBody CommodityRequestDto dto) {
        Commodity commodity = requestMapper.mapToModel(dto);
        commodity.setId(id);
        return responseMapper.mapToDto(commodityService.update(commodity));
    }
}
