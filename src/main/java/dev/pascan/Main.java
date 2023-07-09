package dev.pascan;

import dev.pascan.commands.frc.CompareTeams;
import dev.pascan.commands.frc.WhoIsNumber;
import dev.pascan.commands.general.Ping;
import dev.pascan.commands.general.Ping2;
import dev.pascan.commands.music.AudioManagerCommand;
import dev.pascan.commands.orbits.Satellite;
import dev.pascan.commands.orbits.sgp4.TLE;
import dev.pascan.commands.skyblock.Skyblock;
import dev.pascan.commands.skyblock.SkyblockBot;
import dev.pascan.commands.skyblock.robotcommands.BuyMithrilEqualPriceCommand;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.apache.ApacheHttpClient;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.util.logging.ExceptionLogger;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;

import static dev.pascan.commands.orbits.Pose3d.calcGMST;

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
            //Constants.hypixelAPI = new HypixelAPI(new ApacheHttpClient(UUID.fromString("7538253d-7c49-4035-be24-4827a0b29080")));
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
        try {
            Constants.bot = new SkyblockBot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DiscordApi api = new DiscordApiBuilder()
            .setToken(apiKey)
            .setAllIntents()
            .login()
            .join();
        api.addListener(new Ping());
        api.addListener(new Ping2());
        api.addListener(new Skyblock());
        api.addListener(new BuyMithrilEqualPriceCommand());
        //api.addListener(new WhoIsNumber());
        //api.addListener(new CompareTeams());

        /*
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    String lobbyTypeAndMap = "";
                    lobbyTypeAndMap += Constants.hypixelAPI.getStatus(UUID.fromString("d09c511a-a5ea-4330-b2a7-41792862ec72")).get().getSession().getServerType().getName();
                    lobbyTypeAndMap += " " + Constants.hypixelAPI.getStatus(UUID.fromString("d09c511a-a5ea-4330-b2a7-41792862ec72")).get().getSession().getMode();
                    if (!lobbyTypeAndMap.startsWith("SKYBLOCK")) {
                        new MessageBuilder().append("his ass is NOT on skyblock...\nhis ass is on " + lobbyTypeAndMap).send(api.getUserById(326802645635301377l).get());
                        System.out.println("sent");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 10000);
        */


        /*
        String line1 = "1 25544U 98067A   23151.45322602  .00018605  00000-0  32920-3 0  9995";
        String line2 = "2 25544  51.6408  51.4928 0005626  37.0943 118.6565 15.50332720399191";
        while (true) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                return;
            }
            double gmstSeconds = calcGMST();
            double hours = gmstSeconds / 3600.0 - (gmstSeconds % 3600.0) / 3600.0;
            double minutes = gmstSeconds / 60.0 - (gmstSeconds % 60.0) / 60.0 - hours * 60.0;
            double seconds = gmstSeconds - hours * 3600.0 - minutes * 60.0;

            System.out.printf("Greenwich Sidereal Time is %.0f:%.0f:%.2f%n", hours, minutes, seconds);
        }

         */

    }

    private static void onShardLogin(DiscordApi api) {

        api.addListener(new Ping());
        api.addListener(new AudioManagerCommand());

    }
}