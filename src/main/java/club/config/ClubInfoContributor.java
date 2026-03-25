package club.config;

import club.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClubInfoContributor implements InfoContributor {
    private final PlayerService playerService;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("players", playerService.getAllPlayers().size());
    }
}
