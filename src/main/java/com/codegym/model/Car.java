package com.codegym.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String image;

    private String color;

    private int yearProduce;

    private double price;

    @ManyToOne
    private TypeCar typeCar;

    @ManyToOne
    private Producer producer;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Car(String name, String image, String color, int yearProduce, double price, TypeCar typeCar, Producer producer) {
        this.name = name;
        this.image = image;
        this.color = color;
        this.yearProduce = yearProduce;
        this.price = price;
        this.typeCar = typeCar;
        this.producer = producer;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearProduce() {
        return yearProduce;
    }

    public void setYearProduce(int numProduce) {
        this.yearProduce = yearProduce;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(TypeCar typeCar) {
        this.typeCar = typeCar;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
