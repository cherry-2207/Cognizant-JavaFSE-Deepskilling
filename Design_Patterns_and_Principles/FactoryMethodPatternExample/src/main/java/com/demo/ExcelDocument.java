package com.demo;

public class ExcelDocument implements Document{
    @Override
    public void save() {
        System.out.println("Saving an Excel Document");
    }
    @Override
    public void open() {
        System.out.println("Opening an Excel Document");
    }
}
