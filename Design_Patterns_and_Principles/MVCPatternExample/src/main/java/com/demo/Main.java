package com.demo;

public class Main {

    public static void main(String[] args) {

        // Create Model
        Student student = new Student(
                "Magnus",
                101,
                "A"
        );

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller =
                new StudentController(student, view);

        // Display Initial Details
        System.out.println("Initial Student Details:");
        controller.updateView();

        // Update Student Details
        controller.setStudentName("Magnus Carlson");
        controller.setStudentGrade("A+");

        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}