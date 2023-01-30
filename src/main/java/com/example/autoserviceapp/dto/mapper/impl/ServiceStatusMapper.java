package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.request.StatusRequestDto;
import com.example.autoserviceapp.model.ServiceObject;
import com.example.autoserviceapp.model.ServiceObject.ServiceStatus;
import org.springframework.stereotype.Component;

@Component
public class ServiceStatusMapper implements
        RequestDtoMapper<StatusRequestDto, ServiceObject.ServiceStatus> {
    @Override
    public ServiceStatus mapToModel(StatusRequestDto dto) {
        return ServiceStatus.valueOf(dto.getName());
    }
}
