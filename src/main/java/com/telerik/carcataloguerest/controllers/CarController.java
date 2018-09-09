package com.telerik.carcataloguerest.controllers;

import com.telerik.carcataloguerest.model.Car;
import com.telerik.carcataloguerest.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private CarService allCars;
    private CarService personalCars;

    @Autowired
    public CarController(@Qualifier("all") CarService allCars, @Qualifier("personal") CarService personalCars){
        this.allCars=allCars;
        this.personalCars=personalCars;
    }

    @GetMapping("/getAll")
    public List<Car> getAll(){
        return allCars.getCars();
    }

    @GetMapping("/getPersonal")
    public List<Car> getPersonal(){
        return personalCars.getCars();
    }

    @GetMapping("/getAll/{id}")
    public Car getFromAll(@PathVariable int id){
        return allCars.getCarById(id);
    }

    @GetMapping("/getPersonal/{id}")
    public Car getFromPersonal(@PathVariable int id){
        return personalCars.getCarById(id);
    }

    @PostMapping("/addToAll")
    public void addInAll(@RequestBody Car car){
        allCars.createCar(car);
    }

    @PostMapping("/addToPersonal")
    public void addInPersonal(@RequestBody Car car){
        personalCars.createCar(car);
    }

    @DeleteMapping("/deleteFromAll/{id}")
    public void deleteFromAll(@PathVariable int id){
        allCars.deleteCar(id);
    }

    @DeleteMapping("/deleteFromPersonal/{id}")
    public void deleteFromPersonal(@PathVariable int id){
        personalCars.deleteCar(id);
    }

    @PutMapping("/updateInAll/{id}")
    public void updateInAll(@PathVariable int id, @RequestBody Car car){
        allCars.updateCar(id, car);
    }

    @PutMapping("/updateInPersonal/{id}")
    public void updateInPersonal(@PathVariable int id, @RequestBody Car car){
        personalCars.updateCar(id, car);
    }
}
