package it.untin.progweb.team05.partiteweb.services;

import it.untin.progweb.team05.partiteweb.models.Match;
import it.untin.progweb.team05.partiteweb.models.Team;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchService {

    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private Map<String, Integer> results;

    private final int MATCHES_PER_DAY = 10;

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
        this.results = new HashMap<>();

        generateMatches();
    }

    private void generateMatches() {
        //generate matches
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                matches.add(new Match(teams.get(i), teams.get(j)));
                matches.add(new Match(teams.get(j), teams.get(i)));
            }
        }

        Collections.shuffle(matches);

        //assign match day
        int currentDay = 0;
        int matchesOnCurrentDay = 0;
        for (Match m : matches) {
            m.setMatchDay(currentDay);
            matchesOnCurrentDay++;

            if(matchesOnCurrentDay >= MATCHES_PER_DAY) {
                currentDay++;
                matchesOnCurrentDay = 0;
            }
        }

        //assign result
        for(Match m : matches) {
            results.put(m.getMatchId(), new Random().nextInt(3));
        }
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Match> getMatches(Integer matchday) {
        ArrayList<Match> filtered_matches = new ArrayList<>(matches);
        //sort by matchday only if not filtered by matchday
        if (matchday != null) {
            filtered_matches.removeIf(m -> m.getMatchDay() != matchday);
        } else {
            filtered_matches.sort(Comparator.comparingInt(Match::getMatchDay));
        }
        return filtered_matches;
    }

    public Map<String, Integer> getResults(Integer matchday) {
        ArrayList<Match> filtered_matches = getMatches(matchday);
        Map<String, Integer> filtered_results = new HashMap<>();
        for (Match m : filtered_matches) {
            filtered_results.put(m.getMatchId(), results.get(m.getMatchId()));
        }
        return filtered_results;
    }
}
