package dev.pascan.commands.skyblock.classes.bazaar;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class Product {
    public String product_id;
    public ArrayList<Order> sell_summary;
    public ArrayList<Order> buy_summary;
    public QuickStatus quick_status;

    public Product(String productIdIn, JsonElement element) {
        this.sell_summary = new ArrayList<>();
        this.buy_summary = new ArrayList<>();

        Gson gson = new Gson();
        this.product_id = productIdIn;
        JsonArray sellArray = element.getAsJsonObject().getAsJsonArray("sell_summary");
        for (JsonElement e : sellArray) {
            sell_summary.add(gson.fromJson(e, Order.class));
        }
        JsonArray buyArray = element.getAsJsonObject().getAsJsonArray("buy_summary");
        for (JsonElement e : buyArray) {
            buy_summary.add(gson.fromJson(e, Order.class));
        }
        quick_status = gson.fromJson(element.getAsJsonObject().get("quick_status"), QuickStatus.class);
    }
}

