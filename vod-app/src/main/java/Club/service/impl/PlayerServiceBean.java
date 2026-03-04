package Club.service.impl;

import Club.repository.TeamDao;
import Club.repository.CoachDao;
import Club.repository.PlayerDao;
import Club.model.Team;
import Club.model.Coach;
import Club.model.Player;
import Club.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
@Component
@Scope("prototype")
public class PlayerServiceBean implements PlayerService {

    private static final Logger log = Logger.getLogger(PlayerServiceBean.class.getName());
    private CoachDao coachDao;
    private TeamDao teamDao;
    private PlayerDao playerDao;

    // Poprawione nazwy parametrów w konstruktorze
    public PlayerServiceBean(CoachDao coachDao, TeamDao teamDao, PlayerDao playerDao) {
        this.coachDao = coachDao;
        this.teamDao = teamDao;
        this.playerDao = playerDao;
    }

    @Override
    public List<Player> getAllPlayers() {
        log.info("searching all players...");
        return playerDao.findAll();
    }

    @Override
    public List<Player> getPlayersByCoach(Coach coach) {
        log.info("searching players by coach " + coach.getId());
        return playerDao.findByCoach(coach); // Pamiętaj o zmianie nazwy metody w PlayerDao
    }

    // Odpowiednik szukania filmów w kinie -> zawodnicy w danej drużynie
    public List<Player> getPlayersInTeam(Team team) {
        log.info("searching players in team " + team.getId());
        return playerDao.findByTeam(team); // Pamiętaj o zmianie nazwy metody w PlayerDao
    }

    @Override
    public Player getPlayerById(int id) {
        log.info("searching player by id " + id);
        return playerDao.findById(id);
    }

    public List<Team> getAllTeams() {
        log.info("searching all teams");
        return teamDao.findAll();
    }

    public List<Team> getTeamsByPlayer(Player player) {
        log.info("searching teams for player " + player.getId());
        return teamDao.findByPlayer(player);
    }

    public Team getTeamById(int id) {
        log.info("searching team by id " + id);
        return teamDao.findById(id);
    }

    public List<Coach> getAllCoaches() {
        log.info("searching all coaches");
        return coachDao.findAll();
    }

    public Coach getCoachById(int id) {
        log.info("searching coach by id " + id);
        return coachDao.findById(id);
    }

    @Override
    public Player addPlayer(Player player) {
        log.info("about to add player " + player.getFullName());
        return playerDao.add(player);
    }

    // Jeśli PlayerService ma też zarządzać trenerami:
    public Coach addCoach(Coach coach) {
        log.info("about to add coach " + coach);
        return coachDao.add(coach);
    }
    @Autowired
    public void setCoachDao(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
}