package com.spring.factory;

public class Car {
    private String brand;
    private double price;

    public Car(String brand,double price) {
        super();
        this.brand=brand;
        this.price=price;
    }
    public Car(){
        System.out.println("Car's Constructor");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}