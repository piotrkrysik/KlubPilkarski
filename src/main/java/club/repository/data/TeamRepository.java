package club.repository.data;

import club.model.Player;
import club.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findByNameContainingIgnoreCase(String phrase);

    @Query("select t from Team t inner join t.players player where player=:player")
    public List<Team> findByPlayer(@Param("player") Player player);
}
