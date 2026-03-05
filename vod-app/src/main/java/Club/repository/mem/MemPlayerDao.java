package Club.repository.mem;

import Club.repository.PlayerDao;
import Club.model.Team;
import Club.model.Coach;
import Club.model.Player;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Component
public class MemPlayerDao implements PlayerDao {

    @Override
    public List<Player> findAll() {
        return SampleData.players;
    }

    @Override
    public Player findById(int id) {
        return SampleData.players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Player> findByCoach(Coach coach) {
        return SampleData.players.stream()
                .filter(p -> p.getCoach().equals(coach))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> findByTeam(Team team) {
        return SampleData.players.stream()
                .filter(p -> p.getTeams().contains(team))
                .collect(Collectors.toList());
    }

    @Override
    public Player add(Player player) {
        int max = SampleData.players.stream()
                .mapToInt(Player::getId)
                .max()
                .orElse(0);

        player.setId(++max);
        SampleData.players.add(player);
        return player;
    }
}