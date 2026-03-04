package Club.service;

import Club.model.Team;
import Club.model.Player;

import java.util.List;

public interface TeamService {
//api zwraca nam wszystkie kina
    Team getTeamById(int id);

    List<Team> getAllTeams();

    List<Team> getTeamsByPlayers(Player m);

    List<Player> getPlayersInTeam(Team c);

}
