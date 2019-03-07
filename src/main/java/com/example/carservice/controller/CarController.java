package com.example.carservice.controller;


import com.example.carservice.model.Car;
import com.example.carservice.service.CarService;
import com.example.carservice.util.CustomErrorType;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> listAllCars() {
        List<Car> cars = carService.findAllCars();
        if (cars.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
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

//    @RequestMapping(value = "/car/", method = RequestMethod.POST)
//    public ResponseEntity<?> createCar(@RequestBody Car car, UriComponentsBuilder ucBuilder) {
//        logger.info("Creating Car : {}", car);
        // popraw
//        if (carService.isCarExist(car)) {
//            logger.error("Unable to create. A Car with name {} already exist", car.getNazwa());
//            return new ResponseEntity(new CustomErrorType("Unable to create. A Car with name " + car.getNazwa() + " already exist."), HttpStatus.CONFLICT);
//        }
//        carService.saveCar(car);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/api/car/{id}").buildAndExpand(car.getId()).toUri());
//        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//    }

    //  postaraj się nazpisać samemu
//
    @RequestMapping(value = "/car/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCar(@PathVariable("id") long id, @RequestBody Car car) {
        logger.info("Updating car with id {}", id);
        Car currentCar = carService.findById(id);
        if (currentCar == null) {
         logger.info("Unable to update. Car with id {} not found", id);
          return new ResponseEntity(new CustomErrorType("Unable to update. Carwith id " + id + " not found."), HttpStatus.NOT_FOUND);
       }

       currentCar.setNazwa(car.getNazwa());
       currentCar.setModelSamochodu(car.getModelSamochodu());

     carService.updateCar(currentCar);
      return new ResponseEntity<Car>(currentCar, HttpStatus.OK);

  }

            @RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE)
            public ResponseEntity<?> deleteCar ( @PathVariable("id") long id){
                logger.info("Fetching & Deleting Car by id {}", id);
                Car car = carService.findById(id);
                if (car == null) {
                    logger.info("Unable to delete. Car with id {} not found.", id);
                    return new ResponseEntity(new CustomErrorType("Unable to delete. Car with id " + id + " not found"), HttpStatus.NOT_FOUND);
                }
                carService.deleteCarById(id);
                return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
            }

            @RequestMapping(value = "/car/", method = RequestMethod.DELETE)
            public ResponseEntity<Car> deleteAllCars() {
                logger.info("Deleting all Cars");
                carService.deleteAllCars();
                return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
            }


        }

