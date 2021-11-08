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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appliance appliance = (Appliance) o;

        if (Double.compare(appliance.price, price) != 0) return false;
        return type.equals(appliance.type);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
