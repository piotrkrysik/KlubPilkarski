package Club.repository.mem;

import Club.repository.PlayerDao;
import Club.model.Team;
import Club.model.Coach;
import Club.model.Player;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// Zmieniono nazwę klasy z MemMovieDao na MemPlayerDao
@Primary
@Component
public class MemPlayerDao implements PlayerDao {

    @Override
    public List<Player> findAll() {
        // Zakładamy zmianę nazwy listy w SampleData z movies na players
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
        // Zmieniono z findByDirector na findByCoach
        return SampleData.players.stream()
                .filter(p -> p.getCoach().equals(coach))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> findByTeam(Team team) {
        // Zmieniono z findByCinema na findByTeam
        return SampleData.players.stream()
                .filter(p -> p.getTeams().contains(team))
                .collect(Collectors.toList());
    }

    @Override
    public Player add(Player player) {
        // Logika generowania ID - szukamy najwyższego obecnego ID i dodajemy 1
        int max = SampleData.players.stream()
                .mapToInt(Player::getId)
                .max()
                .orElse(0);

        player.setId(++max);
        SampleData.players.add(player);
        return player;
    }
}