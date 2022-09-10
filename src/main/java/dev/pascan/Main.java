package dev.pascan;

import dev.pascan.commands.general.Ping;
import dev.pascan.commands.general.Ping2;
import dev.pascan.commands.music.AudioManagerCommand;
import dev.pascan.commands.skyblock.Skyblock;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.ExceptionLogger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //read api key from config.properties
        String apiKey = "";
        String skyblockApiKey = "";
        try {
            FileReader reader = new FileReader("src/main/resources/config.properties");
            Properties properties = new Properties();
            properties.load(reader);
            apiKey = properties.getProperty("apiKey");
            skyblockApiKey = properties.getProperty("skyblockApiKey");
            Constants.prefix = properties.getProperty("prefix");
        } catch (Exception e) {
            System.out.println("Error reading config.properties");
            System.exit(1);
        }
        /*new DiscordApiBuilder()
            .setToken(apiKey)
            .setRecommendedTotalShards()
            .join()
            .loginAllShards()
            .forEach(shardFuture -> shardFuture.thenAcceptAsync(Main::onShardLogin)
                .exceptionally(ExceptionLogger.get())
            );

         */
        DiscordApi api = new DiscordApiBuilder()
            .setToken(apiKey)
            .login()
            .join();
        api.addListener(new Ping());
        api.addListener(new Ping2());
        api.addListener(new Skyblock());
    }

    private static void onShardLogin(DiscordApi api) {

        api.addListener(new Ping());
        api.addListener(new AudioManagerCommand());

    }
}