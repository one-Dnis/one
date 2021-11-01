package main.java.by.tc.task01.entity;

public class Laptop extends Appliance {
    // you may add your own code here
    private double batteryCapacity;
    private String os;
    private double memoryRom;
    private double systemMemory;
    private double cpu;
    private double displayInchs;

    public Laptop() {
    }

    public Laptop(String type, double price, double batteryCapacity, String os, double memoryRom, double systemMemory, double cpu, double displayInchs) {
        super(type, price);
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInchs = displayInchs;
    }

    /*//public String getType() {
        return type;
    }*/

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOS() {
        return os;
    }

    public void setOS(String os) {
        this.os = os;
    }

    public double getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(double memoryRom) {
        this.memoryRom = memoryRom;
    }

    public double getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCPU() {
        return cpu;
    }

    public void setCPU(double cpu) {
        this.cpu = cpu;
    }

    public double getDisplayInchs() {
        return displayInchs;
    }

    public void setDisplayInchs(double displayInchs) {
        this.displayInchs = displayInchs;
    }
}

