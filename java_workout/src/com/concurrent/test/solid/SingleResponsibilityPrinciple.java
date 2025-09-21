package com.concurrent.test.solid;

//A class should have only one reason to change.
public class SingleResponsibilityPrinciple {

    // BAD: This class handles both user data and report generation
    class User {
        String name;
        String email;

        public void saveUser() {
            // Save user to database
        }

        public void generateReport() {
            // Generate user report
        }
    }

// GOOD: Split responsibilities into separate classes

    // Handles user data
    class UserData {
        String name;
        String email;
    }

    class UserRepository {
        public void saveUser() {
            // Save user to database
        }
    }

    // Handles report generation
    class ReportGenerator {
        public void generateUserReport(UserData user) {
            // Generate report for the user
        }
    }

}
