package Club.service;

import java.util.List;
import Club.model.Player;
import Club.model.Coach;

public interface PlayerService {

    List<Player> getAllPlayers();

    // Pobiera wszystkich zawodników przypisanych do konkretnego trenera
    List<Player> getPlayersByCoach(Coach coach);

    Player getPlayerById(int id);

    Player addPlayer(Player player);
}