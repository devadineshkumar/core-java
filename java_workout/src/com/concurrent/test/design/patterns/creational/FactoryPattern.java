package com.concurrent.test.design.patterns.creational;

/**
 * Purpose: Creates objects without exposing the instantiation logic to the client.
 * Use Case: When you need to create objects based on some input or condition.
 */
public class FactoryPattern {

    interface Shape {
        void draw();
    }

    class Circle implements Shape {
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    class Square implements Shape {
        public void draw() {
            System.out.println("Drawing Square");
        }
    }

    class ShapeFactory {
        public Shape getShape(String type) {
            if (type.equalsIgnoreCase("circle")) return new Circle();
            if (type.equalsIgnoreCase("square")) return new Square();
            return null;
        }
    }

}
