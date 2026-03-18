package club.service;

import java.util.List;
import club.model.Player;
import club.model.Coach;

public interface PlayerService {

    List<Player> getAllPlayers();

    List<Player> getPlayersByCoach(Coach coach);

    Player getPlayerById(int id);

    Player addPlayer(Player player);

    List<Coach> getAllCoaches();

    Coach getCoachById(int id);

    Coach addCoach(Coach coach);
}