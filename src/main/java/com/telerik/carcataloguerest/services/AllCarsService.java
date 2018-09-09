package com.telerik.carcataloguerest.services;

import com.telerik.carcataloguerest.model.Car;
import com.telerik.carcataloguerest.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("all")
public class AllCarsService implements CarService {

    private final CarRepository repository;

    public AllCarsService(CarRepository repository){
        this.repository=repository;
    }

    @Override
    public void createCar(Car car) {
        repository.createCar(car);
    }

    @Override
    public List<Car> getCars() {
        return repository.getCars();
    }

    @Override
    public Car getCarById(int id) {
        return repository.getCarById(id);
    }

    @Override
    public void updateCar(int id, Car car) {
        repository.updateCar(id, car);
    }

    @Override
    public void deleteCar(int id) {
        repository.deleteCar(id);
    }
}
