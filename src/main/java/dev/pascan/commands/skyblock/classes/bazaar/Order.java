package dev.pascan.commands.skyblock.classes.bazaar;

public class Order {
    public long amount;
    public double pricePerUnit;
    public long orders;

    public Order(long amount, double pricePerUnit, long orders) {
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
        this.orders = orders;
    }

    public long getAmount() {
        return this.amount;
    }

    public double getPricePerUnit() {
        return this.pricePerUnit;
    }

    public long getOrders() {
        return this.orders;
    }
}
