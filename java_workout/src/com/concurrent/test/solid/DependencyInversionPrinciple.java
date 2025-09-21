package com.concurrent.test.solid;

//High-level modules should not depend on low-level modules. Both should depend on abstractions.
public class DependencyInversionPrinciple {

    // BAD: High-level class depends on low-level class
    class MySQLDatabase {
        public void connect() {
            // Connect to MySQL
        }
    }

    class Application {
        MySQLDatabase db = new MySQLDatabase();

        public void start() {
            db.connect(); // Tightly coupled
        }
    }

    // GOOD: Depend on abstraction
    interface Database {
        void connect();
    }

    class MySQL implements Database {
        public void connect() {
            // Connect to MySQL
        }
    }

    class PostgreSQL implements Database {
        public void connect() {
            // Connect to PostgreSQL
        }
    }

    class App {
        private Database db;

        public App(Database db) {
            this.db = db;
        }

        public void start() {
            db.connect(); // Loosely coupled
        }
    }

}
