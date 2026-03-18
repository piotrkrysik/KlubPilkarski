package club.repository.jpa;

import club.model.Player;
import club.model.Team;
import club.repository.TeamDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaTeamDao implements TeamDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Team> findAll() {
        return entityManager
                .createQuery("SELECT t FROM Team t")
                .getResultList();
    }
    @Override
    public Team findById(int id) {
        return entityManager.find(Team.class, id);
    }
    @Override
    public List<Team> findByPlayer(Player p) {
        return entityManager
                .createQuery("select t from Team t inner join t.players player where player=:player")
                .setParameter("player", p)
                .getResultList();
    }
    @Override
    public Team save(Team team) {
        entityManager.persist(team);
        return team;
    }
    @Override
    public List<Team> findByPhrase(String phrase) {
        return entityManager.createQuery("SELECT t FROM Team t WHERE t.name LIKE :phrase", Team.class)
                .setParameter("phrase", "%" + phrase + "%")
                .getResultList();
    }
}
