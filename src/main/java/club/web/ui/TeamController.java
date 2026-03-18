package club.web.ui;

import club.model.Player;
import club.model.Team;
import club.service.PlayerService;
import club.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TeamController {

    private final TeamService teamService;
    private final PlayerService playerService;

    @GetMapping("/teams")
    String getTeams(
            Model model,
            @RequestParam(value = "playerId", required = false) Integer playerId) {

        // Dodaj ten log na samym początku, żeby na 100% wiedzieć czy metoda ruszyła
        log.info("WYWOŁANO METODĘ getTeams Z PARAMETREM playerId: {}", playerId);

        List<Team> teams;
        String pageTitle;

        if (playerId != null) {
            Player player = playerService.getPlayerById(playerId);
            teams = teamService.getTeamsByPlayers(player);
            pageTitle = "Teams having player: " + (player != null ? player.getName() : "Unknown");
        } else {
            teams = teamService.getAllTeams();
            pageTitle = "All Teams";
        }

        model.addAttribute("teams", teams);
        model.addAttribute("title", pageTitle); // Zmienione z "name" na "title"
        model.addAttribute("tip", "Wskazówka: Wybierz drużynę, aby zobaczyć szczegóły");

        return "teamsView"; // Upewnij się, że plik nazywa się teamsView.html
    }
}
