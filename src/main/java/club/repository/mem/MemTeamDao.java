package club.repository.mem;

import club.repository.TeamDao;
import club.model.Team;
import club.model.Player;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("teamDao")
public class MemTeamDao implements TeamDao {

    @Override
    public List<Team> findAll() {
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
        return SampleData.teams.stream()
                .filter(team -> team.getPlayers().contains(player))
                .collect(Collectors.toList());
    }

    public Team save(Team team) {
        int maxId = SampleData.teams.stream()
                .sorted((c1, c2)-> c2.getId()- c1.getId())
                .findFirst()
                .map(c -> c.getId())
                .orElse(0);
        team.setId(maxId + 1);
        SampleData.teams.add(team);
        return team;
    }

    @Override
    public List<Team> findByPhrase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return findAll();
        }

        return SampleData.teams.stream()
                .filter(team -> team.getName().toLowerCase()
                        .contains(phrase.toLowerCase()))
                .collect(Collectors.toList());
    }
}