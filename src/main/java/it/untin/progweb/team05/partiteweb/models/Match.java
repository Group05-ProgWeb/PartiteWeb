package it.untin.progweb.team05.partiteweb.models;

import java.util.Random;
import java.util.UUID;

public class Match {
    private String match_id;
    private Team home;
    private Team away;
    private int matchDay;
    private int result;

    public Match() {}

    public Match(Team home, Team away) {
        this.match_id = UUID.randomUUID().toString();
        this.home = home;
        this.away = away;
        this.result = -1;
    }

    public String getMatch_id() {
        return match_id;
    }
    public Team getHome() {
        return home;
    }
    public Team getAway() {
        return away;
    }
    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public void populateResult() {
        if(result == -1) {
            result = new Random().nextInt(3);
        }
    }
}
