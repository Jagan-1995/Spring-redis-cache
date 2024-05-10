package com.ecommerceproject.rediscachedemo.repository;

import com.ecommerceproject.rediscachedemo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
