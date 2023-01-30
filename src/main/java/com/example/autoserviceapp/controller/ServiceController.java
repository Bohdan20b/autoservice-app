package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.ServiceRequestDto;
import com.example.autoserviceapp.dto.request.StatusRequestDto;
import com.example.autoserviceapp.dto.response.ServiceResponseDto;
import com.example.autoserviceapp.model.ServiceObject;
import com.example.autoserviceapp.model.ServiceObject.ServiceStatus;
import com.example.autoserviceapp.service.ServiceObjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceObjectService serviceObjectService;
    private final RequestDtoMapper<ServiceRequestDto, ServiceObject> serviceRequestMapper;
    private final ResponseDtoMapper<ServiceResponseDto, ServiceObject> serviceResponseMapper;
    private final RequestDtoMapper<StatusRequestDto, ServiceObject.ServiceStatus> statusMapper;

    public ServiceController(ServiceObjectService serviceObjectService,
            RequestDtoMapper<ServiceRequestDto, ServiceObject> serviceRequestMapper,
            ResponseDtoMapper<ServiceResponseDto, ServiceObject> serviceResponseMapper,
            RequestDtoMapper<StatusRequestDto, ServiceObject.ServiceStatus> statusMapper) {
        this.serviceObjectService = serviceObjectService;
        this.serviceRequestMapper = serviceRequestMapper;
        this.serviceResponseMapper = serviceResponseMapper;
        this.statusMapper = statusMapper;
    }

    @PostMapping
    public ServiceResponseDto create(@RequestBody ServiceRequestDto dto) {
        ServiceObject service = serviceRequestMapper.mapToModel(dto);
        return serviceResponseMapper.mapToDto(serviceObjectService.add(service));
    }

    @PostMapping("/{id}")
    public ServiceResponseDto update(@PathVariable Long id, @RequestBody ServiceRequestDto dto) {
        ServiceObject service = serviceRequestMapper.mapToModel(dto);
        service.setId(id);
        return serviceResponseMapper.mapToDto(serviceObjectService.update(service));
    }

    @GetMapping("/{id}/status")
    public ServiceResponseDto updateStatus(@PathVariable Long id, @RequestBody StatusRequestDto dto) {
        ServiceObject.ServiceStatus status = statusMapper.mapToModel(dto);
        return serviceResponseMapper.mapToDto(serviceObjectService.updateServiceStatus(id, status));
    }
}
