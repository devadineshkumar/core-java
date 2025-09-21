package com.concurrent.test.design.patterns.creational;

/**
 * Purpose: Creates families of related objects without specifying their concrete classes.
 * Use Case: When you need to create multiple related objects (e.g., UI components for different OS themes).
 */
public class AbstractFactoryPatter {

    // Abstract product interfaces
    interface Button {
        void render();
    }

    interface Checkbox {
        void render();
    }

    // Concrete products for Windows
    class WindowsButton implements Button {
        public void render() {
            System.out.println("Windows Button");
        }
    }

    class WindowsCheckbox implements Checkbox {
        public void render() {
            System.out.println("Windows Checkbox");
        }
    }

    // Concrete products for Mac
    class MacButton implements Button {
        public void render() {
            System.out.println("Mac Button");
        }
    }

    class MacCheckbox implements Checkbox {
        public void render() {
            System.out.println("Mac Checkbox");
        }
    }

    // Abstract factory
    interface GUIFactory {
        Button createButton();

        Checkbox createCheckbox();
    }

    // Concrete factories
    class WindowsFactory implements GUIFactory {
        public Button createButton() {
            return new WindowsButton();
        }

        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }

    class MacFactory implements GUIFactory {
        public Button createButton() {
            return new MacButton();
        }

        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }

}
