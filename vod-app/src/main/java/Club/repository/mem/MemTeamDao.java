package Club.repository.mem;

import Club.repository.TeamDao;
import Club.model.Team;
import Club.model.Player;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// Zmieniono nazwę klasy z MemCinemaDao na MemTeamDao
@Component
@Primary
public class MemTeamDao implements TeamDao {

    @Override
    public List<Team> findAll() {
        // Zakładamy, że w SampleData zmieniłeś nazwę listy na teams
        return SampleData.teams;
    }

    @Override
    public Team findById(int id) {
        return SampleData.teams.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Team> findByPlayer(Player player) {
        // Zmieniono z findByMovie na findByPlayer
        // Metoda szuka drużyn, które na swojej liście zawodników posiadają dany obiekt Player
        return SampleData.teams.stream()
                .filter(team -> team.getPlayers().contains(player))
                .collect(Collectors.toList());
    }
}