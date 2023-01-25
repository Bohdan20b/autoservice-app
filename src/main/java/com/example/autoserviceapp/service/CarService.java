package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Car;

public interface CarService {
    Car add(Car car);

    Car update(Car car);

    Car get(Long id);
}
