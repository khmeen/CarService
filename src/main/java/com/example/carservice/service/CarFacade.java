package com.example.carservice.service;

import com.example.carservice.dto.CarRequest;
import com.example.carservice.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CarFacade {

    @Autowired
    private CarService carService;

    @Autowired
    private ModelMapper modelMapper;

    public CarRequest getCarById(Long id) {
        return convertToCarDto(carService.findById(id));
    }

    private CarRequest convertToCarDto(Car car) {
        CarRequest carRequest = modelMapper.map(car, CarRequest.class);
        return carRequest;
    }


}
