package com.example.autoserviceapp.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponseDto {
    private Long id;
    private List<Long> carIdList;
    private List<Long> orderIdList;
}
