package dev.pascan.commands.frc.api;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Team {
    public int team;
    public String name;
    public boolean offseason;
    public String state;
    public String country;
    public String district;
    public int rookie_year;
    public boolean active;
    public int norm_epa;
    public int norm_epa_recent;
    public int norm_epa_mean;
    public int norm_epa_max;
    public int wins;
    public int losses;
    public int ties;
    public int count;
    public double winrate;
    public int full_wins;
    public int full_losses;
    public int full_ties;
    public int full_count;
    public double full_winrate;

    public Team(String jsonString) {
        Gson gson = new Gson();
        Team teamObj = gson.fromJson(jsonString, Team.class);

        this.team = teamObj.team;
        this.name = teamObj.name;
        this.offseason = teamObj.offseason;
        this.state = teamObj.state;
        this.country = teamObj.country;
        this.district = teamObj.district;
        this.rookie_year = teamObj.rookie_year;
        this.active = teamObj.active;
        this.norm_epa = teamObj.norm_epa;
        this.norm_epa_recent = teamObj.norm_epa_recent;
        this.norm_epa_mean = teamObj.norm_epa_mean;
        this.norm_epa_max = teamObj.norm_epa_max;
        this.wins = teamObj.wins;
        this.losses = teamObj.losses;
        this.ties = teamObj.ties;
        this.count = teamObj.count;
        this.winrate = teamObj.winrate;
        this.full_wins = teamObj.full_wins;
        this.full_losses = teamObj.full_losses;
        this.full_ties = teamObj.full_ties;
        this.full_count = teamObj.full_count;
        this.full_winrate = teamObj.full_winrate;
    }

    @Override
    public String toString() {
        return "Team: " + team +
            "\nName: " + name +
            "\nOffseason: " + offseason +
            "\nState: " + state +
            "\nCountry: " + country +
            "\nDistrict: " + district +
            "\nRookie Year: " + rookie_year +
            "\nActive: " + active +
            "\nNorm EPA: " + norm_epa +
            "\nNorm EPA Recent: " + norm_epa_recent +
            "\nNorm EPA Mean: " + norm_epa_mean +
            "\nNorm EPA Max: " + norm_epa_max +
            "\nWins: " + wins +
            "\nLosses: " + losses +
            "\nTies: " + ties +
            "\nCount: " + count +
            "\nWin Rate: " + winrate +
            "\nFull Wins: " + full_wins +
            "\nFull Losses: " + full_losses +
            "\nFull Ties: " + full_ties +
            "\nFull Count: " + full_count +
            "\nFull Win Rate: " + full_winrate;
    }

    public Team(int teamNumber) throws IOException {
        String apiUrl = "https://api.statbotics.io/v2/team/" + teamNumber;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url(apiUrl)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonString = response.body().string();
                Team teamObj = new Team(jsonString);

                // Assign fields from the retrieved JSON string
                this.team = teamObj.team;
                this.name = teamObj.name;
                this.offseason = teamObj.offseason;
                this.state = teamObj.state;
                this.country = teamObj.country;
                this.district = teamObj.district;
                this.rookie_year = teamObj.rookie_year;
                this.active = teamObj.active;
                this.norm_epa = teamObj.norm_epa;
                this.norm_epa_recent = teamObj.norm_epa_recent;
                this.norm_epa_mean = teamObj.norm_epa_mean;
                this.norm_epa_max = teamObj.norm_epa_max;
                this.wins = teamObj.wins;
                this.losses = teamObj.losses;
                this.ties = teamObj.ties;
                this.count = teamObj.count;
                this.winrate = teamObj.winrate;
                this.full_wins = teamObj.full_wins;
                this.full_losses = teamObj.full_losses;
                this.full_ties = teamObj.full_ties;
                this.full_count = teamObj.full_count;
                this.full_winrate = teamObj.full_winrate;
            } else {
                throw new IOException("Request failed with HTTP code: " + response.code());
            }
        }
    }

}
