package main.java.by.tc.task01.entity;

public class Appliance {
    // you may add your own code here
    private String type;
    private double price;

    public Appliance() {
    }

    public Appliance(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
