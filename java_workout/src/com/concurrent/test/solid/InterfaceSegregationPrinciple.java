package com.concurrent.test.solid;

//Clients should not be forced to depend on interfaces they do not use.
public class InterfaceSegregationPrinciple {
    // BAD: One interface with too many responsibilities
    interface Worker {
        void work();

        void eat();
    }

    class Robot implements Worker {
        public void work() {
            // Robot works
        }

        public void eat() {
            // Robot doesn't eat — violates ISP
        }
    }

    // GOOD: Split into smaller interfaces
    interface Workable {
        void work();
    }

    interface Eatable {
        void eat();
    }

    class Human implements Workable, Eatable {
        public void work() {
            // Human works
        }

        public void eat() {
            // Human eats
        }
    }

    class RobotWorker implements Workable {
        public void work() {
            // Robot works
        }
    }

}
