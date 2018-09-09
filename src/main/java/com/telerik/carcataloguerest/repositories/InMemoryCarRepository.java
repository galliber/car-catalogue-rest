package com.telerik.carcataloguerest.repositories;

import com.telerik.carcataloguerest.model.Car;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("prototype")
public class InMemoryCarRepository implements CarRepository {

    private List<Car> cars=new ArrayList();
    public InMemoryCarRepository(){
        cars.add(new Car(0, "Audi", "A3", 143, 2000,""));
        cars.add(new Car(1, "Audi", "S5", 354, 3000,""));
        cars.add(new Car(2, "Mercedess-Benz", "S600", 5900, 600,""));
    }

    @Override
    public void createCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        return cars.stream().filter(car->car.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void updateCar(int id, Car car) {
        cars.set(cars.indexOf(cars.stream().filter(car1->car1.getId()==id).findFirst().orElse(null)), car);
    }

    @Override
    public void deleteCar(int id) {
        if(!cars.isEmpty()) {
            Car car=cars.stream().filter(car1->car1.getId()==id).findFirst().orElse(null);
            if(car!=null) {
                cars.remove(cars.indexOf(car));
            }
        }
    }
}
