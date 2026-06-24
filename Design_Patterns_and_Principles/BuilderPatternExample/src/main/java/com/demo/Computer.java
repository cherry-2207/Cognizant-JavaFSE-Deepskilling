package com.demo;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;
    private boolean isBluetoothEnabled;
    private boolean isWifiEnabled;
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isWifiEnabled = builder.isWifiEnabled;
    }
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }
    public boolean isWifiEnabled() { return isWifiEnabled; }
    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage +
                ", GraphicsCard=" + graphicsCard + ", Bluetooth=" + isBluetoothEnabled +
                ", WiFi=" + isWifiEnabled + "]";
    }
    public static class Builder {
        // Same attributes as the outer class
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;
        private boolean isBluetoothEnabled;
        private boolean isWifiEnabled;
        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }
        public Builder setWifiEnabled(boolean isWifiEnabled) {
            this.isWifiEnabled = isWifiEnabled;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}
