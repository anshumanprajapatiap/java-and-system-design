package com.anshumanprajapati.designpattern.creational.factorypattern;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("CIRCLE");
        shapeFactory.getShape("SQUARE");
        shapeFactory.getShape("RECTANGLE");
    }
}
