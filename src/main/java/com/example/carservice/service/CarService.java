package com.example.carservice.service;

import com.example.carservice.model.Car;

import java.util.List;

public interface CarService {
    Car findById(long id);

    Car findByName(String name);

    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCarById(long id);

    void deleteAllCars();

    boolean isCarExist(Car car);

    List<Car> findAllCars();
}
