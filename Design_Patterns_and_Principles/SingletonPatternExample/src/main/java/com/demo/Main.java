package com.demo;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Application Started");
        logger2.log("User logged in");
        System.out.println("Checking whether both the objects are same");
        if(logger1.equals(logger2)) {
            System.out.println("Only one Logger instance exists");
        } else {
            System.out.println("Different Logger instances exist");
        }
        System.out.println("Logger 1 Hashcode: " + logger1.hashCode());
        System.out.println("Logger 2 Hashcode: " + logger2.hashCode());
    }
}