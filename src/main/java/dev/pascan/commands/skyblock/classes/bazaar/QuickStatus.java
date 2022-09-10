package dev.pascan.commands.skyblock.classes.bazaar;

public class QuickStatus {
    public String productId;
    public double sellPrice;
    public long sellVolume;
    public long sellMovingWeek;
    public long sellOrders;
    public double buyPrice;
    public long buyVolume;
    public long buyMovingWeek;
    public long buyOrders;

    public QuickStatus(String productId, double sellPrice, long sellVolume, long sellMovingWeek, long sellOrders, double buyPrice, long buyVolume, long buyMovingWeek, long buyOrders) {
        this.productId = productId;
        this.sellPrice = sellPrice;
        this.sellVolume = sellVolume;
        this.sellMovingWeek = sellMovingWeek;
        this.sellOrders = sellOrders;
        this.buyPrice = buyPrice;
        this.buyVolume = buyVolume;
        this.buyMovingWeek = buyMovingWeek;
        this.buyOrders = buyOrders;
    }
}
