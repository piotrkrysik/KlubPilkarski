package club.web.ui;

import club.model.Coach;
import club.model.Player;
import club.model.Team;
import club.service.PlayerService;
import club.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;

    @GetMapping("/players")
    String getPlayers(Model model,
                      @RequestParam(value = "teamId", required = false) Integer teamId,
                      @RequestParam(value = "coachId", required = false) Integer coachId) {
        log.info("about to display players list in team {}", teamId);
        if (teamId != null) {
            Team team = teamService.getTeamById(teamId);
            List<Player> players = teamService.getPlayersInTeam(team);
            model.addAttribute("players", players);
            model.addAttribute("name", "Players in team " + team.getName() + "'");
        } else if (coachId != null) {
            Coach coach = playerService.getCoachById(coachId);
            List<Player> players = playerService.getPlayersByCoach(coach);
            model.addAttribute("players", players);
            model.addAttribute("name", "Players trained by coach " + coach.getLastName() + "'");
        } else {
            List<Player> players = playerService.getAllPlayers();
            model.addAttribute("players", players);
            model.addAttribute("name","Players");
        }
        return "playersView";
    }
}
