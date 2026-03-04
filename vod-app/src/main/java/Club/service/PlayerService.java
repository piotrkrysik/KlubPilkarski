package Club.service;

import java.util.List;
import Club.model.Player;
import Club.model.Coach;

public interface PlayerService {

    // Zmienione z getAllMovies()
    List<Player> getAllPlayers();

    // Zmienione z getMoviesByDirector(Coach d)
    // Pobiera wszystkich zawodników przypisanych do konkretnego trenera
    List<Player> getPlayersByCoach(Coach coach);

    // Zmienione z getMovieById(int id)
    Player getPlayerById(int id);

    // Zmienione z addMovie(Player m)
    Player addPlayer(Player player);
}