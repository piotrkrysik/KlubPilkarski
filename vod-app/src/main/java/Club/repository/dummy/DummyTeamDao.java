package Club.repository.dummy;

import Club.model.Player;
import Club.model.Team;
import Club.repository.TeamDao;
import org.springframework.stereotype.Component; // Import dla adnotacji @Component

import java.util.List;

@Component // Adnotacja, dzięki której Spring utworzy ten obiekt w kontekście
public class DummyTeamDao implements TeamDao {

    @Override
    public List<Team> findAll() {
        return List.of(); // Zwraca pustą listę (dostępne od Javy 9)
    }

    @Override
    public Team findById(int id) {
        return null; // Implementacja "dummy" zazwyczaj zwraca null lub puste dane
    }

    @Override
    public List<Team> findByPlayer(Player player) {
        return List.of(); // Kolejna metoda wymagana przez interfejs TeamDao
    }
}