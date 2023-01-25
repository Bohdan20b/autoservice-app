package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.CommodityRequestDto;
import com.example.autoserviceapp.dto.response.CommodityResponseDto;
import com.example.autoserviceapp.model.Commodity;
import org.springframework.stereotype.Component;

@Component
public class CommodityMapper implements RequestDtoMapper<CommodityRequestDto, Commodity>,
        ResponseDtoMapper<CommodityResponseDto, Commodity> {
    @Override
    public Commodity mapToModel(CommodityRequestDto dto) {
        Commodity commodity = new Commodity();
        commodity.setName(dto.getName());
        commodity.setPrice(dto.getPrice());
        return commodity;
    }

    @Override
    public CommodityResponseDto mapToDto(Commodity commodity) {
        CommodityResponseDto dto = new CommodityResponseDto();
        dto.setId(commodity.getId());
        dto.setName(commodity.getName());
        dto.setPrice(commodity.getPrice());
        return dto;
    }
}
