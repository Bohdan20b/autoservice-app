package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.repository.CarRepository;
import com.example.autoserviceapp.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car add(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car get(Long id) {
        return carRepository.getReferenceById(id);
    }
}
