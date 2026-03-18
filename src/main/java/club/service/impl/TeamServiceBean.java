package club.service.impl;

import club.model.Team;
import club.model.Player;
import club.repository.TeamDao;
import club.repository.PlayerDao;
import club.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class TeamServiceBean implements TeamService {

    private static final Logger log = Logger.getLogger(TeamService.class.getName());

    private TeamDao teamDao;
    private PlayerDao playerDao;
    @Autowired
    public TeamServiceBean(TeamDao cinemaDao, PlayerDao movieDao) {
        log.info("creating team service bean");
        this.teamDao = cinemaDao;
        this.playerDao = movieDao;
    }

    @Override
    public Team getTeamById(int id) {
        log.info("searching team by id " + id);
        return teamDao.findById(id);
    }

    @Override
    public List<Player> getPlayersInTeam(Team c) {
        log.info("searching players playing in team " + c.getId());
        return playerDao.findByTeam(c);
    }

    @Override
    public List<Team> getAllTeams() {
        log.info("searching all teams");
        return teamDao.findAll();
    }

    @Override
    public List<Team> getTeamsByPlayers(Player m) {
        log.info("searching teams by players " + m.getId());
        return teamDao.findByPlayer(m);
    }

    @Override
    public Team addTeam(Team team) {
        log.info("Adding new team: " + team.getName());
        return teamDao.save(team);
    }

    @Override
    public List<Player> getPlayersInTeam(int teamId) {
        log.info("Searching players for team id: " + teamId);
        Team team = teamDao.findById(teamId);
        if (team == null) return java.util.Collections.emptyList();
        return playerDao.findByTeam(team);
    }

    public List<Team> getTeamsByPhrase(String phrase) {
        log.info("Searching teams by phrase " + phrase);
        return teamDao.findByPhrase(phrase);
    }
}
