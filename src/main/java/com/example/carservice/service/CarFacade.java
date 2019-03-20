package com.example.carservice.service;

import com.example.carservice.dto.CarDto;
import com.example.carservice.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CarFacade {

    @Autowired
    private CarService carService;

    @Autowired
    private ModelMapper modelMapper;

    public CarDto getCarById(Long id) {
        return convertToCarDto(carService.findById(id));
    }

    private CarDto convertToCarDto(Car car) {
        CarDto carDto = modelMapper.map(car, CarDto.class);
        return carDto;
    }


}
