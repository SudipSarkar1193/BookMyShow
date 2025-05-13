package enums;

public enum SeatCategory {
    Silver(80.0),
    Gold(140.0),
    Platinum(200.0);

    private final double price;

    SeatCategory(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}