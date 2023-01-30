package com.example.autoserviceapp.dto.request;

import com.example.autoserviceapp.model.ServiceObject;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class ServiceRequestDto {
    private Long orderId;
    private Long masterId;
    private BigDecimal price;
    private ServiceObject.ServiceStatus status;
}
