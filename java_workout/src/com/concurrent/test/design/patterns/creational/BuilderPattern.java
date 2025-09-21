package com.concurrent.test.design.patterns.creational;

public class BuilderPattern {

    public static void main(String[] args) {
        // Example usage of the Builder Pattern
        Car car = new Car.Builder()
                .setEngine("V8")
                .setWheels(4)
                .setSunroof(true)
                .build();

        System.out.println("Car built with engine: " + car);
    }

}

class Car {
    private String engine;
    private int wheels;
    private boolean sunroof;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
    }

    public static class Builder {
        private String engine;
        private int wheels;
        private boolean sunroof;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

