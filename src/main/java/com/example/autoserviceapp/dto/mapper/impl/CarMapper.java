package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.mapper.RequestDtoMapper;
import com.example.autoserviceapp.dto.mapper.ResponseDtoMapper;
import com.example.autoserviceapp.dto.request.CarRequestDto;
import com.example.autoserviceapp.dto.response.CarResponseDto;
import com.example.autoserviceapp.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements RequestDtoMapper<CarRequestDto, Car>,
        ResponseDtoMapper<CarResponseDto, Car> {

    @Override
    public Car mapToModel(CarRequestDto dto) {
        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setSeries(dto.getSeries());
        return car;
    }

    @Override
    public CarResponseDto mapToDto(Car car) {
        CarResponseDto dto = new CarResponseDto();
        dto.setId(car.getId());
        dto.setBrand(car.getBrand());
        dto.setYear(car.getYear());
        dto.setSeries(car.getSeries());
        return dto;
    }
}
