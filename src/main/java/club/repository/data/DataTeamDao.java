package club.repository.data;

import club.model.Player;
import club.model.Team;
import club.repository.TeamDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataTeamDao implements TeamDao {
    private final TeamRepository repository;
    @Override
    public List<Team> findAll() {return repository.findAll();}
    @Override
    public Team findById (int id){return repository.findById(id).orElse(null);}

    @Override
    public List<Team> findByPlayer(Player p) {return repository.findByPlayer(p);}
    @Override
    public Team save(Team team) {return repository.save(team);}
    @Override
    public List<Team> findByPhrase(String phrase) {
        return repository.findByNameContainingIgnoreCase(phrase);
    }
}
