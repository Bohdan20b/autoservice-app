package com.example.autoserviceapp.dto.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommodityRequestDto {
    private String name;
    private BigDecimal price;
}
