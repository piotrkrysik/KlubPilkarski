package club.repository.data;

import club.model.Coach;
import club.model.Player;
import club.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllByTeamsContaining(Team team);

    List<Player> findAllByCoach(Coach coach);
}
