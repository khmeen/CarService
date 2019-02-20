package com.example.carservice.service;

import com.example.carservice.model.Car;
import com.example.carservice.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>(Arrays.asList(
            new Car(1, "Audi", "Q7"),
            new Car(2, "Alfa Romeo", "MiTo"),
            new Car(3, "Fiat", "Bravo")
    ));

    public List<Car> getAllCars() {
        return cars;
    }

    //public Car getCar(long id){
        //return cars.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    //}

    public void addCar(Car car) {
        cars.add(car);
    }
    // private CarRepository carRepository;

    //  public List<Car> getAllCar() {
    //    List<Car> cars = new ArrayList<>();
    //  carRepository.findAll().forEach(cars::add);
    //return cars;
    //}
    //public void addCar(Car car) {
    //  carRepository.save(car);
    //}
}
