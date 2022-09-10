package dev.pascan.commands.skyblock;

import dev.pascan.Constants;
import dev.pascan.commands.skyblock.classes.bazaar.Bazaar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class SkyblockAPI {
    private static final String URL = "https://api.hypixel.net/skyblock";
    private static String KEY;
    private static OkHttpClient client = new OkHttpClient();
    private static Bazaar bazaar;

    public static String getJson(String uri) {
        Request request = new Request.Builder()
            .url(URL + uri)
            .addHeader("API-KEY", "6ff3c19c-5aae-4824-a4d6-17766f086c9b")
            .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get skyblock json data");
        }
        return "epic fail";
    }

    public static Bazaar getBazaar() {
        updateBazaar();
        return bazaar;
    }

    private static void updateBazaar() {
        bazaar = new Bazaar(getJson("/bazaar"));
    }

}
