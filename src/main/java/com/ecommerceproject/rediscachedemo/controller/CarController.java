package com.ecommerceproject.rediscachedemo.controller;


import com.ecommerceproject.rediscachedemo.model.Car;
import com.ecommerceproject.rediscachedemo.service.CarService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "car")
    public Car getCar(@PathVariable("id") Long carId){

        return carService.getCarById(carId);

    }

    @GetMapping("/")
    @Cacheable(value = "car")
    public List<Car> getCars(){
        return carService.getAllCar();
    }

    @PostMapping("/create")
    @CachePut(key = "#car.company", value = "car")
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car.getCompany(),car.getModel());

    }

//    @CachePut(value = "car", key = "#car.id", unless = "#car.company == null")
//    @PutMapping("/{id}")
//    public Car updateCar(@PathVariable("id") int carId, @RequestBody Car car){
//        //call service and update details for the given id
//        return null;
//    }

//    @CacheEvict(value = "car", key = "#car.id")
//    @DeleteMapping("/{id}")
//    public Car deleteCar(@PathVariable("id") Long carId) {
//        Car c = carService.getCarById(carId);
//        carService.deleteCar(carId);
//        return c;
//    }

    @DeleteMapping("/all")
    public void deleteAllCars(){
        carService.deleteCars();
    }
}
