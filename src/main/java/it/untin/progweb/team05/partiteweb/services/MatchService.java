package it.untin.progweb.team05.partiteweb.services;

import it.untin.progweb.team05.partiteweb.models.Match;
import it.untin.progweb.team05.partiteweb.models.Result;
import it.untin.progweb.team05.partiteweb.models.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class MatchService {

    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private ArrayList<Result> results;

    private final int tournament_days = 4;

    public MatchService() {
        this.teams = new ArrayList<>() {
            {
                add(new Team("Juventus"));
                add(new Team("Inter"));
                add(new Team("Milan"));
                add(new Team("Sampdoria"));
                add(new Team("Napoli"));
                add(new Team("Cagliari"));
                add(new Team("USD Gardolo"));
                add(new Team("US Vibonese Calcio"));
            }
        };
        this.matches = new ArrayList<>();
        this.results = new ArrayList<>();

        generateMatches();
    }

    private void generateMatches() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                matches.add(new Match(teams.get(i), teams.get(j)));
                matches.add(new Match(teams.get(j), teams.get(i)));
            }
        }

        Collections.shuffle(matches);

        for (int i = 0; i < matches.size(); i++) {
            Match match = matches.get(i);
            match.setMatchDay((i % tournament_days) + 1);
            results.add(new Result(match.getMatch_id(), Result.randomWinner()));
        }
    }

//    public ArrayList<Result> getResults(Integer matchday) {
//        ArrayList<Result> filtered_results = new ArrayList<>(results);
//    }


    public ArrayList<Match> getMatches(Integer matchday, Boolean sort) {
        ArrayList<Match> filtered_matches = new ArrayList<>(matches);
        if (matchday != null) {
            filtered_matches.removeIf(m -> m.getMatchDay() != matchday);
        } else if(sort == Boolean.TRUE) {
            filtered_matches.sort(Comparator.comparingInt(Match::getMatchDay));
        }
        return matches;
    }
}
