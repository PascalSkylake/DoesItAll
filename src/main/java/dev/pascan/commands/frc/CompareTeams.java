package dev.pascan.commands.frc;

import dev.pascan.commands.frc.api.TeamYear;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareTeams implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String m = event.getMessageContent();

        if (m.startsWith("!compare")) {
            System.out.println(m);
            int firstTeam = 1;
            int secondTeam = 1;
            int year = 2023;

            Pattern p = Pattern.compile("\\d+");
            Matcher matcher = p.matcher(m);
            if (matcher.find()) {
                firstTeam = Integer.parseInt(matcher.group());
            }
            if (matcher.find()) {
                secondTeam = Integer.parseInt(matcher.group());
            }
            if (matcher.find()) {
                year = Integer.parseInt(matcher.group());
            }

            try {
                TeamYear firstTeamYear = TeamYear.getTeamYear(firstTeam, year);
                TeamYear secondTeamYear = TeamYear.getTeamYear(secondTeam, year);
                String reply = "";
                reply =
                    "Overall, " + (firstTeamYear.epa_end >= secondTeamYear.epa_end ? firstTeam : secondTeam) + " was better." + "```" +
                        "\n\t\t\t\t " + firstTeam + "\t\t   " + secondTeam +
                        "\nEPA:\t\t\t " + firstTeamYear.epa_end + "\t\t" + secondTeamYear.epa_end +
                        "\nAuto EPA:\t\t" + firstTeamYear.auto_epa_end + "\t\t" + secondTeamYear.auto_epa_end +
                        "\nTele EPA:\t\t" + firstTeamYear.teleop_epa_end + "\t\t" + secondTeamYear.teleop_epa_end +
                        "\nEnd EPA:\t\t " + firstTeamYear.endgame_epa_end + "\t\t" + secondTeamYear.endgame_epa_end +
                        "\nWinrate: \t\t" + firstTeamYear.full_winrate + "\t\t" + secondTeamYear.full_winrate +
                        "\n```";
                //System.out.println(reply);
                event.getMessage().reply(reply);


            } catch (Exception e) {
                event.getMessage().reply("whar");
                return;
            }


        }
    }
}
