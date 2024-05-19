package com.ecommerceproject.rediscachedemo.service;


import com.ecommerceproject.rediscachedemo.model.Car;
import com.ecommerceproject.rediscachedemo.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarById(Long id){
        return carRepository.findById(id).get();
    }

    public List<Car> getAllCar(){
        return carRepository.findAll();
    }

    public Car createCar(String company, String model){
        Car car = new Car();
        car.setCompany(company);
        car.setModel(model);

        carRepository.save(car);

        return car;

    }

//    public void deleteCar(Long carId) {
//         carRepository.deleteById(carId);
//    }

    public void deleteCars(){
        carRepository.deleteAll();
    }
}
