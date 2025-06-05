package it.untin.progweb.team05.partiteweb.models;

import java.util.Random;

public class Result {
    private String match_id;
    private int winner;

    public Result() {}

    public Result(String match_id, int winner) {
        this.match_id = match_id;
        this.winner = winner;
    }

    public static int randomWinner() {
        Random rand = new Random();
        return rand.nextInt(3);
    }
}
