package dev.pascan.commands.frc.api;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class TeamYear {
    public int year;
    public int team;
    public boolean offseason;
    public String name;
    public String state;
    public String country;
    public String district;
    public boolean is_competing;
    public double epa_start;
    public double epa_pre_champs;
    public double epa_end;
    public double epa_mean;
    public double epa_max;
    public double epa_diff;
    public double auto_epa_start;
    public double auto_epa_pre_champs;
    public double auto_epa_end;
    public double auto_epa_mean;
    public double auto_epa_max;
    public double teleop_epa_start;
    public double teleop_epa_pre_champs;
    public double teleop_epa_end;
    public double teleop_epa_mean;
    public double teleop_epa_max;
    public double endgame_epa_start;
    public double endgame_epa_pre_champs;
    public double endgame_epa_end;
    public double endgame_epa_mean;
    public double endgame_epa_max;
    public double rp_1_epa_start;
    public double rp_1_epa_pre_champs;
    public double rp_1_epa_end;
    public double rp_1_epa_mean;
    public double rp_1_epa_max;
    public double rp_2_epa_start;
    public double rp_2_epa_pre_champs;
    public double rp_2_epa_end;
    public double rp_2_epa_mean;
    public double rp_2_epa_max;
    public double unitless_epa_end;
    public double norm_epa_end;
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
    public int total_epa_rank;
    public double total_epa_percentile;
    public int total_team_count;
    public int country_epa_rank;
    public double country_epa_percentile;
    public int country_team_count;
    public int state_epa_rank;
    public double state_epa_percentile;
    public int state_team_count;
    public int district_epa_rank;
    public double district_epa_percentile;
    public int district_team_count;

    public static TeamYear fromJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, TeamYear.class);
    }

    public static TeamYear getTeamYear(int team, int year) throws IOException {
        String url = "https://api.statbotics.io/v2/team_year/" + team + "/" + year;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        return fromJson(jsonString);
    }

    @Override
    public String toString() {
        return "Year: " + year +
            "\nTeam: " + team +
            "\nName: " + name +
            "\nState: " + state +
            "\nCountry: " + country +
            "\nDistrict: " + district +
            "\nIs Competing: " + is_competing +
            "\nEPA Start: " + epa_start +
            "\nEPA End: " + epa_end +
            "\nEPA Mean: " + epa_mean +
            "\nAuto EPA Start: " + auto_epa_start +
            "\nAuto EPA End: " + auto_epa_end +
            "\nAuto EPA Mean: " + auto_epa_mean +
            "\nTeleop EPA Start: " + teleop_epa_start +
            "\nTeleop EPA End: " + teleop_epa_end +
            "\nTeleop EPA Mean: " + teleop_epa_mean +
            "\nEndgame EPA Start: " + endgame_epa_start +
            "\nEndgame EPA End: " + endgame_epa_end +
            "\nEndgame EPA Mean: " + endgame_epa_mean +
            "\nRP 1 EPA End: " + rp_1_epa_end +
            "\nRP 2 EPA End: " + rp_2_epa_end +
            "\nUnitless EPA End: " + unitless_epa_end +
            "\nNorm EPA End: " + norm_epa_end +
            "\nWins: " + wins +
            "\nLosses: " + losses +
            "\nTies: " + ties +
            "\nCount: " + count +
            "\nWinrate: " + winrate +
            "\nTotal EPA Rank: " + total_epa_rank +
            "\nTotal EPA Percentile: " + total_epa_percentile +
            "\nTotal Team Count: " + total_team_count +
            "\nCountry EPA Rank: " + country_epa_rank +
            "\nCountry EPA Percentile: " + country_epa_percentile +
            "\nCountry Team Count: " + country_team_count +
            "\nState EPA Rank: " + state_epa_rank +
            "\nState EPA Percentile: " + state_epa_percentile +
            "\nState Team Count: " + state_team_count +
            "\nDistrict EPA Rank: " + district_epa_rank +
            "\nDistrict EPA Percentile: " + district_epa_percentile +
            "\nDistrict Team Count: " + district_team_count;
    }

}
