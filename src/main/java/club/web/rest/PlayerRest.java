package club.web.rest;

import club.model.Player;
import club.model.Team;
import club.service.PlayerService;
import club.service.TeamService;
import club.web.rest.dto.PlayerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class PlayerRest {

    private final TeamService teamService;
    private final PlayerService playerService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/players")
    List<Player> getPlayers() {
        log.info("about to get players");
        List<Player> players = playerService.getAllPlayers();
        log.info("{} players found", players.size());
        return players;
    }

    @GetMapping("/players/{id}")
    ResponseEntity<Player> getPlayer(@PathVariable("id") int id) {
        log.info("about to get player {}", id);
        Player player = playerService.getPlayerById(id);
        log.info("{} player found", player);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/teams/{teamId}/players")
    ResponseEntity<List<Player>> getPlayersInTeam(@PathVariable("teamId") int teamId) {
        log.info("about to retrieve teams by player {}", teamId);
        Team team = teamService.getTeamById(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Player> players = teamService.getPlayersInTeam(team);
            log.info("{} teams found", players.size(), team.getName());
            return ResponseEntity.ok(players);
        }
    }

    @PostMapping("/players")
    public ResponseEntity<?> addPlayer(@Validated @RequestBody PlayerDTO playerDTO, Errors errors) {
        log.info("about to add player {}", playerDTO);
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setPhotoUrl(playerDTO.getPhotoUrl());
        player.setMarketValue(playerDTO.getMarketValue());
        player.setCoach(playerService.getCoachById(playerDTO.getCoachId()));

        player = playerService.addPlayer(player);
        log.info("{} player added", player);
        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + player.getId())
                        .build()
                        .toUri())
                .body(player);
    }
}
