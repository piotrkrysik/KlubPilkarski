package club.service;

import club.model.Team;
import club.model.Player;

import java.util.List;

public interface TeamService {
    Team getTeamById(int id);

    List<Team> getAllTeams();

    List<Team> getTeamsByPlayers(Player m);

    List<Player> getPlayersInTeam(Team c);

    Team addTeam(Team team);
    List<Player> getPlayersInTeam(int teamId);

    List<Team> getTeamsByPhrase(String phrase);
}
