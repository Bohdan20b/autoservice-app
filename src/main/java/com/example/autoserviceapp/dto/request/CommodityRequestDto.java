package com.example.autoserviceapp.dto.request;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class CommodityRequestDto {
    private String name;
    private BigDecimal price;
}
