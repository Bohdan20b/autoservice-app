package com.example.autoserviceapp.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterRequestDto {
    private String fullName;
    private List<Long> completeOrders;
}
