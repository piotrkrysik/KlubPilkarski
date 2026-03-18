package club.repository;

import club.model.Team;
import club.model.Player;

import java.util.List;

public interface TeamDao {

    // Pobiera listę wszystkich drużyn
    List<Team> findAll();
    List<Team> findByPhrase(String phrase);
    // Szuka konkretnej drużyny po jej ID
    Team findById(int id);

    // Pobiera listę drużyn, w których grał dany zawodnik
    List<Team> findByPlayer(Player player);

    Team save(Team team);
}