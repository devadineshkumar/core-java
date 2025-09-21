package com.concurrent.test.solid;

//Software entities should be open for extension, but closed for modification.
public class OpenClosedPrinciple {
    // BAD: Adding new shapes requires modifying the AreaCalculator
    class AreaCalculator {
        public double calculateArea(Object shape) {
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                return Math.PI * c.radius * c.radius;
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                return r.length * r.width;
            }
            return 0;
        }
    }

    // GOOD: Use polymorphism to extend without modifying
    interface Shape {
        double area();
    }

    class Circle implements Shape {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double area() {
            return Math.PI * radius * radius;
        }
    }

    class Rectangle implements Shape {
        double length, width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double area() {
            return length * width;
        }
    }

    class AreaCalculator1 {
        public double calculateArea(Shape shape) {
            return shape.area(); // No need to modify this method for new shapes
        }
    }
}

