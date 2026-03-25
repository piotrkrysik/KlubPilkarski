package club.repository.data;

import club.model.Coach;
import club.model.Player;
import club.model.Team;
import club.repository.PlayerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Primary
@Repository
@RequiredArgsConstructor
public class DataPlayerDao implements PlayerDao {
    private final PlayerRepository repository;
    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public Player findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Player> findByCoach(Coach coach) {
        return repository.findAllByCoach(coach);
    }

    @Override
    public List<Player> findByTeam(Team team) {
        return repository.findAllByTeamsContaining(team);
    }
    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Player add(Player player) {
        return repository.save(player);
    }
}
