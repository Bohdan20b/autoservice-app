package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.CarRequestDto;
import com.example.autoserviceapp.dto.response.CarResponseDto;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.service.CarService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final RequestDtoMapper<CarRequestDto, Car> requestMapper;
    private final ResponseDtoMapper<CarResponseDto, Car> responseMapper;

    public CarController(CarService carService, RequestDtoMapper<CarRequestDto, Car> requestMapper,
            ResponseDtoMapper<CarResponseDto, Car> responseMapper) {
        this.carService = carService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public  CarResponseDto create(@RequestBody CarRequestDto dto) {
        Car car = carService.add(requestMapper.mapToModel(dto));
        return responseMapper.mapToDto(car);
    }

    @PostMapping("/{id}")
    public CarResponseDto update(@PathVariable Long id, @RequestBody CarRequestDto dto) {
        Car car = requestMapper.mapToModel(dto);
        car.setId(id);
        return responseMapper.mapToDto(carService.update(car));
    }
}
