package com.demo;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Building a Gaming Computer ---");
        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel Core i9")
                .setRam("32GB DDR5")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setBluetoothEnabled(true)
                .setWifiEnabled(true)
                .build();

        System.out.println(gamingPC);

        System.out.println("\n--- Building a Basic Office Computer ---");
        Computer officePC = new Computer.Builder()
                .setCpu("Intel Core i5")
                .setRam("8GB DDR4")
                .setStorage("512GB SSD")
                .setWifiEnabled(true)
                .build();

        System.out.println(officePC);

        System.out.println("\n--- Building a Home Server ---");
        Computer homeServer = new Computer.Builder()
                .setCpu("AMD Ryzen 7")
                .setRam("64GB DDR4")
                .setStorage("16TB HDD Raid 5")
                .build();

        System.out.println(homeServer);
    }
}