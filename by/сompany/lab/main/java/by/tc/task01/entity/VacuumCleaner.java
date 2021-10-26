package main.java.by.tc.task01.entity;

public class VacuumCleaner extends Appliance {
    // you may add your own code here
    private String type;
    private double powerConsumption;
    private String filterType;
    private double bagType;
    private double wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleaner() {
    }

    public VacuumCleaner(String type, double powerConsumption, String filterType, double bagType, double wandType, double motorSpeedRegulation, double cleaningWidth) {
        this.type = type;
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public String getType() {
        return type;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public double getBagType() {
        return bagType;
    }

    public void setBagType(double bagType) {
        this.bagType = bagType;
    }

    public double getWandType() {
        return wandType;
    }

    public void setWandType(double wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }
}
