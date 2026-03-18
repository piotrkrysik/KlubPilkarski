package club.repository.jpa;

import club.model.Coach;
import club.model.Player;
import club.model.Team;
import club.repository.PlayerDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Primary
public class JpaPlayerDao implements PlayerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> findAll() {
        return entityManager.createQuery(
                "select p from Player p").getResultList();
    }

    @Override
    public Player findById(int id) {return entityManager.find(Player.class, id);}

    @Override
    public List<Player> findByCoach(Coach c){
        return entityManager
                .createQuery("select p from Player p where p.coach=:coach")
                .setParameter("coach", c)
                .getResultList();
    }
    @Override
    public List<Player> findByTeam(Team t){
        return entityManager.createQuery(
                "select p from Player p inner join p.teams team where team=:team")
                .setParameter("team", t)
                .getResultList();
    }
    @Override
    public Player add(Player p) {
        entityManager.persist(p);
        return p;
    }
}
