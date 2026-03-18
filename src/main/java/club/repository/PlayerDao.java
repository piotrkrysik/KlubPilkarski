package club.repository;

import club.model.Team;
import club.model.Coach;
import club.model.Player;

import java.util.List;

public interface PlayerDao {

    // Pobiera wszystkich zawodników
    List<Player> findAll();

    // Szuka zawodnika po jego unikalnym ID
    Player findById(int id);

    // Pobiera zawodników przypisanych do konkretnego trenera
    List<Player> findByCoach(Coach coach);

    // Pobiera zawodników grających w danej drużynie
    List<Player> findByTeam(Team team);

    // Dodaje nowego zawodnika do bazy
    Player add(Player player);

}