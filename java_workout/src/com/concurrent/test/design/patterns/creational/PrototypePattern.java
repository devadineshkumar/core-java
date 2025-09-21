package com.concurrent.test.design.patterns.creational;

public class PrototypePattern {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.setId("1");
        Shape clonedCircle = circle.clone();
        clonedCircle.setId("2");

        System.out.println("Original Circle ID: " + circle.getType() + " with ID: " + circle.getId());
        System.out.println("Cloned Circle ID: " + clonedCircle.getType() + " with ID: " + clonedCircle.getId());

        // Draw both shapes
        circle.draw();
        clonedCircle.draw();
    }
}

abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Shape clone() {
        Shape clone = null;
        try {
            clone = (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

