package dev.pascan.commands.skyblock.classes.bazaar;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.Map;

public class Bazaar {
    long lastUpdated;
    public ArrayList<Product> products;

    public Bazaar(String jsonString) {
        products = new ArrayList<>();
        JsonObject productArray = JsonParser.parseString(jsonString).getAsJsonObject().getAsJsonObject("products");
        for (Map.Entry<String, JsonElement> entry : productArray.entrySet()) {
            products.add(new Product(entry.getKey(), entry.getValue()));
        }
    }
}
