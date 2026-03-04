package Club.service.impl;

import Club.model.Team;
import Club.model.Player;
import Club.repository.TeamDao;
import Club.repository.PlayerDao;
import Club.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
@Component
public class TeamServiceBean implements TeamService {

    private static final Logger log = Logger.getLogger(TeamService.class.getName());

    private TeamDao teamDao;
    private PlayerDao playerDao;
    @Autowired
    public TeamServiceBean(TeamDao cinemaDao, PlayerDao movieDao) {
        log.info("creating cinema service bean");
        this.teamDao = cinemaDao;
        this.playerDao = movieDao;
    }

    @Override
    public Team getTeamById(int id) {
        log.info("searching cinema by id " + id);
        return teamDao.findById(id);
    }

    @Override
    public List<Player> getPlayersInTeam(Team c) {
        log.info("searching movies played in cinema " + c.getId());
        return playerDao.findByTeam(c);
    }

    @Override
    public List<Team> getAllTeams() {
        log.info("searching all cinemas");
        return teamDao.findAll();
    }

    @Override
    public List<Team> getTeamsByPlayers(Player m) {
        log.info("searching cinemas by movie " + m.getId());
        return teamDao.findByPlayer(m);
    }

}
