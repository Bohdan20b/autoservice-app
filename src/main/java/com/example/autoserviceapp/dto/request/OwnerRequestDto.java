package com.example.autoserviceapp.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerRequestDto {
    private List<Long> carIdList;
    private List<Long> orderIdList;
}
