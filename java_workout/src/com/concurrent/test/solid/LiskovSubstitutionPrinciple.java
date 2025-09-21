package com.concurrent.test.solid;

//Subtypes must be substitutable for their base types.
public class LiskovSubstitutionPrinciple {
    // BAD: Square breaks the behavior of Rectangle
    class Rectangle {
        protected int width, height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getArea() {
            return width * height;
        }
    }

    class Square extends Rectangle {
        public void setWidth(int width) {
            this.width = width;
            this.height = width; // Violates LSP
        }

        public void setHeight(int height) {
            this.width = height;
            this.height = height; // Violates LSP
        }
    }

    // GOOD: Separate Square and Rectangle if behavior differs
    interface Shape {
        int getArea();
    }

    class ProperRectangle implements Shape {
        int width, height;

        public ProperRectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getArea() {
            return width * height;
        }
    }

    class ProperSquare implements Shape {
        int side;

        public ProperSquare(int side) {
            this.side = side;
        }

        public int getArea() {
            return side * side;
        }
    }

}
