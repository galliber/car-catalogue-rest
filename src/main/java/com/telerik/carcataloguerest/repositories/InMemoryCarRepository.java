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
        cars.add(new Car(0, "Audi", "A3", 143, 2000,"https://assets.gocar.be/picserver1/userdata/1/25733/VmlTxhgqF/kfz46260792_capture7.jpg"));
        cars.add(new Car(1, "Audi", "S5", 354, 3000,"https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/audi-s5-uk-0818.jpg?itok=TyKkb6xu"));
        cars.add(new Car(2, "Mercedes-Benz", "S600", 5900, 600,"https://d3lp4xedbqa8a5.cloudfront.net/imagegen/max/ccr/1023/-/s3/digital-cougar-assets/motor/2015/10/26/48222/Mercedes-Maybach-S600-cover-2.jpg"));
    }

    @Override
    public void createCar(Car car) {
        Car toAdd=null;
        if(car.getImgUrl().length()<25||car.getImgUrl()==""){
            toAdd=new Car(car.getId(), car.getMake(), car.getModel(), car.getPower(), car.getCubicCapacity(), "https://increasify.com.au/wp-content/uploads/2016/08/default-image.png");
        }
        else
            toAdd=car;
        cars.add(toAdd);
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
