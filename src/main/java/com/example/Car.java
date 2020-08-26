package com.example;

public class Car {
    private String value;
    private String flowerColor;
    private Integer index;
    public Car() {
    }

    public Car(String value, String flowerColor, Integer index) {
        this.value = value;
        this.flowerColor = flowerColor;
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
