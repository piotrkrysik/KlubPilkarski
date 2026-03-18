package club;

import club.service.TeamService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ClubComponent {
    private final TeamService teamService;

    @PostConstruct
    public void init() {
        log.info("Aplikacja wystartowała!");
        teamService.getAllTeams().forEach(t -> log.info(t.toString()));
    }
}