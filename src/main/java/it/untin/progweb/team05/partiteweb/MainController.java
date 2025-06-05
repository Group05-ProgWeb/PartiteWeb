package it.untin.progweb.team05.partiteweb;

import it.untin.progweb.team05.partiteweb.models.Match;
import it.untin.progweb.team05.partiteweb.services.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class MainController {

    MatchService matchService;

    public MainController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matches")
    public ArrayList<Match> matches(@RequestParam(required = false) Boolean sort,
                                    @RequestParam(required = false) Integer matchday) {
        return matchService.getMatches(matchday, sort);
    }

//    @GetMapping("/results")
//    public ArrayList<Match> results(@RequestParam() Integer matchday) {
//
//    }
}
