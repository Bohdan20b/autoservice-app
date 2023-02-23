package com.example.autoserviceapp.dto.request;

import com.example.autoserviceapp.model.Order;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Long carId;
    private String problem;
    private LocalDateTime acceptTime;
    private List<Long> serviceIdList;
    private List<Long> commodityIdList;
    private Order.Status status;
    private LocalDateTime completeTime;
}
