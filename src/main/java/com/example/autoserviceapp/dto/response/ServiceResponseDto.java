package com.example.autoserviceapp.dto.response;

import com.example.autoserviceapp.model.ServiceObject;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private BigDecimal price;
    private ServiceObject.ServiceStatus status;
}
