package com.example.carservice.service;

import com.example.carservice.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CarServiceImpl implements CarService {
    private static final AtomicLong counter = new AtomicLong();

    private static List<Car> cars;

    static {
        cars = populateCars();
    }

    public List<Car> findAllCars() {
        return cars;
    }

    public Car findById(long id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public Car findByName(String nazwa) {
        for (Car car : cars) {
            if (car.getNazwa().equalsIgnoreCase(nazwa)) {
                return car;
            }
        }
        return null;
    }

    public void saveCar(Car car) {
        car.setId(counter.incrementAndGet());
        cars.add(car);
    }

    @Override
    public void updateCar(Car car) {
        int index = cars.indexOf(car);
        cars.set(index, car);
    }

    @Override
    public void deleteCarById(long id) {
        for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext();) {
            Car car = iterator.next();
            if (car.getId() == id) {
                iterator.remove();
            }
        }
    }


    @Override
    public boolean isCarExist(Car car) {
        return findByName(car.getNazwa()) != null;
    }

    public void deleteAllCars() {
        cars.clear();
    }


    private static List<Car> populateCars() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(counter.incrementAndGet(), "Audi", "Q5"));
        cars.add(new Car(counter.incrementAndGet(), "Audi", "Q7"));
        cars.add(new Car(counter.incrementAndGet(), "BMW", "520d"));
        cars.add(new Car(counter.incrementAndGet(), "Renault", "Laguna"));
        cars.add(new Car(counter.incrementAndGet(), "Alfa Romeo", "MiTo"));
        return cars;
    }

}
