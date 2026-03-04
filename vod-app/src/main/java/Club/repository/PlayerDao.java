package Club.repository;

import Club.model.Team;
import Club.model.Coach;
import Club.model.Player;

import java.util.List;

public interface PlayerDao {

    // Pobiera wszystkich zawodników
    List<Player> findAll();

    // Szuka zawodnika po jego unikalnym ID
    Player findById(int id);

    // Zmienione z findByDirector na findByCoach
    // Pobiera zawodników przypisanych do konkretnego trenera
    List<Player> findByCoach(Coach coach);

    // Zmienione z findByCinema na findByTeam
    // Pobiera zawodników grających w danej drużynie
    List<Player> findByTeam(Team team);

    // Dodaje nowego zawodnika do bazy
    Player add(Player player);

}