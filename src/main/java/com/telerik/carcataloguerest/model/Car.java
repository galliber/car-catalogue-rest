package com.telerik.carcataloguerest.model;

public class Car {
    private int id;
    private String make;
    private String model;
    private int power;
    private int cubicCapacity;
    private String imgUrl;
    public Car(){
    }

    public Car(int id, String make, String model, int power, int cubicCapacity,String imgUrl){
        this.id=id;
        this.make=make;
        this.model=model;
        this.power=power;
        this.cubicCapacity=cubicCapacity;
        this.imgUrl=imgUrl;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
