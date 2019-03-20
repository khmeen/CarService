package com.example.carservice.service;

import com.example.carservice.dto.CarDto;
import com.example.carservice.model.Car;
import com.example.carservice.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Car findByName(String nazwa) {return  carRepository.findByNazwa(nazwa); }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public boolean isCarExist (Car car) { return carRepository.findByNazwa(car.getNazwa())!=null;}

    //postaraj się napisać update samemu

    public void updateCar(Car car) { carRepository.save(car);}


    @Override
    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }







}


