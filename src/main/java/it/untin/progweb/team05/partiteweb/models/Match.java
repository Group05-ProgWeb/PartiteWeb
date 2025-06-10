package it.untin.progweb.team05.partiteweb.models;

import java.util.Random;
import java.util.UUID;

public class Match {
    private String matchId;
    private Team home;
    private Team away;
    private int matchDay;

    public Match() {}

    public Match(Team home, Team away) {
        this.matchId = UUID.randomUUID().toString();
        this.home = home;
        this.away = away;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }
}
