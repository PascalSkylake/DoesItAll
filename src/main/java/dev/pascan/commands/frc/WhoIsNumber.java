package dev.pascan.commands.frc;

import dev.pascan.commands.frc.api.Team;
import dev.pascan.commands.frc.api.TeamYear;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhoIsNumber implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String m = event.getMessageContent();
        if (m.startsWith("!t") && !m.contains("compare")) {
            System.out.println(m);
            try {
                int teamNumber = 1;
                int yearNumber = 2023;

                Pattern p = Pattern.compile("\\d+");
                Matcher matcher = p.matcher(m);
                if (matcher.find()) {
                    teamNumber = Integer.parseInt(matcher.group());

                } else {
                    for (int i = 0; i < m.length(); i++) {
                        teamNumber += m.toCharArray()[i];
                    }
                }
                if (matcher.find()) {
                    yearNumber = Integer.parseInt(matcher.group());
                }
                System.out.println("tn" + teamNumber);
                System.out.println("yn" + yearNumber);
                TeamYear teamYear = TeamYear.getTeamYear(teamNumber, yearNumber);
                TeamYear ourTeamYear = TeamYear.getTeamYear(4342, yearNumber);

                if (!m.contains("y")) {
                    String reply = (teamYear.name) + "\n" +
                        "Are they better than us? " + (teamYear.epa_end > ourTeamYear.epa_end ? "yes" : "no") +
                        "\n" + teamYear.epa_end + " vs " + ourTeamYear.epa_end + " points scored per game";
                    if (m.endsWith("b")) {
                        event.getMessage().reply(teamYear.toString());
                    } else {
                        event.getMessage().reply(reply);
                    }
                } else {
                    event.getMessage().reply(teamYear.toString());
                }
            } catch (IOException e) {
                event.getMessage().reply("whar");
            }
        }
    }
}
