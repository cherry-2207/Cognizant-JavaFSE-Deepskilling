package com.demo;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a word document....");
    }
    @Override
    public void save() {
        System.out.println("Saving a word document....");
    }
}
