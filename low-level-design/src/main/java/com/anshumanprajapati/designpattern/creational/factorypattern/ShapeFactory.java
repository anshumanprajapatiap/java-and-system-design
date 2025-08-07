package com.anshumanprajapati.designpattern.creational.factorypattern;

public class ShapeFactory {

    Shape getShape(String input){
        switch(input){
            case "CIRCLE":
                return new Circle();
            case "SQUARE":
                return new Square();
            case "RECTANGE":
                return new Rectangle();
            default:
                return null;
        }
    }
}
