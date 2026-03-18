package club.web.rest;

import club.model.Player;
import club.model.Team;
import club.service.PlayerService;
import club.service.TeamService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class TeamRest {

    private final TeamService teamService;
    private final PlayerService playerService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/teams")
    public List<Team> getTeams(@RequestParam(value = "phrase", required = false) String phrase,
                               @RequestHeader(value = "custom-header", required = false) String customHeader,
                               @CookieValue(value = "some-cookie", required = false) String someCookie
    ) {
        log.info("about to retrieve teams list");
        log.info("phrase param: {}", phrase);
        log.info("custom-header param: {}", customHeader);
        log.info("some-cookie value: {}", someCookie);

        if(phrase!=null && phrase.equals("foo")){
            throw new IllegalArgumentException("Foo!");
        }

        List<Team> teams;
        if(phrase != null && !phrase.isEmpty()) {
            teams = teamService.getTeamsByPhrase(phrase);
        }else {
            teams = teamService.getAllTeams();
        }
        log.info("{} teams found", teams.size());
        return teams;
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable("id") int id) {
        log.info("about to retrieve team {}", id);
        Team team = teamService.getTeamById(id);

        if (team != null) {
            return ResponseEntity.ok(team);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/teams")
    public ResponseEntity<?> addTeam(@Validated @RequestBody Team team, Errors errors, HttpServletRequest request) {
        log.info("about to add new team {}", team);

        if (errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);

            String errorMessage = errors.getAllErrors().stream()
                    .map(objectError -> messageSource.getMessage(objectError.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accumulator, error) -> accumulator + error + "\n");

            log.info("Validation failed: {}", errorMessage);
            return ResponseEntity.badRequest().body(errorMessage);
        }

        team = teamService.addTeam(team);
        log.info("{} team added", team);
        return ResponseEntity.status(HttpStatus.CREATED).body(team);
    }
}