package com.ecommerceproject.rediscachedemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private CarService carService;

    public ScheduledTask(CarService carService) {
        this.carService = carService;
    }

//    second minutes hours day Month dayOfWeek
//      *       *      *    *    *      *
//      0 0 9 * * *  -> 9 AM everyday
//      0 0 17 * * 1 -> 5pm Monday
    @Scheduled(cron = "* * * * * *")
    public void execute(){
//        carService.deleteCars();
        System.out.println("Crons jobs was called");

    }
}
