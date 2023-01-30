package com.example.autoserviceapp.dto.request;

import java.util.List;
import lombok.Getter;

@Getter
public class OwnerRequestDto {
    private List<Long> carIdList;
    private List<Long> orderIdList;
}
