package com.example.carservice.service;

import com.example.carservice.dto.CarRequest;
import com.example.carservice.dto.CarResponse;
import com.example.carservice.dto.GetCarRequest;
import com.example.carservice.model.Car;
import com.example.carservice.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void addCar(CarRequest request) {
        Car car = new Car();
        car.setModelSamochodu(request.getModelSamochodu());
        car.setNazwa(request.getNazwa());

        carRepository.save(car);
    }

    @Override
    public CarResponse car(long id) {
        final Car car = carRepository.getOne(id);

        CarResponse carResponse = new CarResponse();
        carResponse.setNazwa(car.getNazwa());
        carResponse.setModelSamochodu(car.getModelSamochodu());
        carResponse.setId(car.getId());

        return carResponse;
    }

    @Override
    public List<CarResponse> cars() {
        final List<Car> cars = carRepository.findAll();

        return cars.stream().map(item -> {
            CarResponse car = new CarResponse();
            car.setId(item.getId());
            car.setModelSamochodu(item.getModelSamochodu());
            car.setNazwa(item.getNazwa());

            return car;
        }).collect(Collectors.toList());
    }


   // @Override
    //public void updateCar(Long id, CarRequest request) {
    //    CarRequest car = carRepository.findById(id);

    //}



    public Car findById(long id) {
        return carRepository.getOne(id);
    }

    public Car findByName(String nazwa) {
        return carRepository.findByNazwa(nazwa);
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCar(Long id, CarRequest request) {
        Car updateCar = carRepository.getOne(id);
        updateCar.setModelSamochodu(request.getModelSamochodu());
        updateCar.setNazwa(request.getNazwa());
        carRepository.save(updateCar);
    }

    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }



}




