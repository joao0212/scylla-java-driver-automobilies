package com.br.car;

import java.util.UUID;

public class Car {

    public Car(UUID id, String brand, String color, String model) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.model = model;
    }

    private final UUID id;
    private final String brand;
    private final String color;
    private final String model;

    public UUID getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }
}
