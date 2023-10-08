package Enums;

public enum Categories {
    SPORT("Sport", 150),
    HISTORY("History", 250),
    TECHNOLOGY("Technology", 180),
    CLASSICS("Classics",100);

    private String name;
    private double price;

    Categories(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}