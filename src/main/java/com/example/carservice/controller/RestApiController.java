package com.example.carservice.controller;


import com.example.carservice.model.Car;
import com.example.carservice.service.CarService;
import com.example.carservice.util.CustomErrorType;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;



@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    CarService carService;

    @RequestMapping(value = "/car/", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> listAllCars() {
        List<Car> cars = carService.findAllCars();
            if (cars.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new  ResponseEntity<List<Car>>(cars,HttpStatus.OK);
        }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCar(@PathVariable("id") long id) {
        logger.info("Fetching Car with id {}", id);
        Car car = carService.findById(id);
        if (car == null) {
            logger.error("Car with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }
    @RequestMapping(value = "/car/", method = RequestMethod.POST)
    public ResponseEntity<?> createCar(@RequestBody Car car, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Car : {}", car);

        if (carService.isCarExist(car)) {
            logger.error("Unable to create. A Car with name {} already exist", car.getNazwa());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Car with name " + car.getNazwa() + " already exist."), HttpStatus.CONFLICT);
        }
        carService.saveCar(car);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(car.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


}
