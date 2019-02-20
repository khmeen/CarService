package com.example.carservice.service;

import com.example.carservice.model.Car;
import com.example.carservice.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Car findById(long id) {
        return carRepository.getOne(id);
    }

    public Car findByName(String nazwa) {
        return carRepository.findByNazwa(nazwa);
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    //postaraj się napisać update samemu
//    @Override
//    public void updateCar(Car car) {
//        int index = cars.indexOf(car);
//        cars.set(index, car);
//    }

    @Override
    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}