package Club.repository.dummy;

import Club.model.Player;
import Club.model.Team;
import Club.repository.TeamDao;
import org.springframework.stereotype.Component; // Import dla adnotacji @Component

import java.util.List;

@Component
public class DummyTeamDao implements TeamDao {

    @Override
    public List<Team> findAll() {
        return List.of();
    }

    @Override
    public Team findById(int id) {return null;}

    @Override
    public List<Team> findByPlayer(Player player) {
        return List.of();
    }
}