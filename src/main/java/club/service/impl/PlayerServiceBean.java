package club.service.impl;

import club.repository.TeamDao;
import club.repository.CoachDao;
import club.repository.PlayerDao;
import club.model.Team;
import club.model.Coach;
import club.model.Player;
import club.service.PlayerService;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.logging.Logger;
@Service
@Scope("prototype")
public class PlayerServiceBean implements PlayerService {

    private static final Logger log = Logger.getLogger(PlayerServiceBean.class.getName());
    private final CoachDao coachDao;
    private final TeamDao teamDao;
    private final PlayerDao playerDao;
    private final PlatformTransactionManager transactionManager;

    public PlayerServiceBean(CoachDao coachDao, TeamDao teamDao, PlayerDao playerDao, PlatformTransactionManager transactionManager) {
        this.coachDao = coachDao;
        this.teamDao = teamDao;
        this.playerDao = playerDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public List<Player> getAllPlayers() {
        log.info("searching all players...");
        return playerDao.findAll();
    }

    @Override
    public List<Player> getPlayersByCoach(Coach coach) {
        log.info("searching players by coach " + coach.getId());
        return playerDao.findByCoach(coach);
    }

    // Odpowiednik szukania filmów w kinie -> zawodnicy w danej drużynie
    public List<Player> getPlayersInTeam(Team team) {
        log.info("searching players in team " + team.getId());
        return playerDao.findByTeam(team);
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
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Player addPlayer(Player player) {
        log.info("about to add player " + player.getName());
        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            player = playerDao.add(player);
            if(player.getName().equals("Oskar Pietuszewski")) {
                throw new RuntimeException("not yet");
            }
            transactionManager.commit(ts);
        } catch (RuntimeException e) {
            transactionManager.rollback(ts);
            throw e;
        }
        return player;
    }

    // Jeśli PlayerService ma też zarządzać trenerami:
    public Coach addCoach(Coach coach) {
        log.info("about to add coach " + coach);
        return coachDao.add(coach);
    }
}