package Club.repository;

import Club.model.Team;
import Club.model.Player;

import java.util.List;

public interface TeamDao {

    // Pobiera listę wszystkich drużyn
    List<Team> findAll();

    // Szuka konkretnej drużyny po jej ID
    Team findById(int id);

    // Zmienione z findByMovie(Player m)
    // Pobiera listę drużyn, w których grał dany zawodnik
    List<Team> findByPlayer(Player player);

}