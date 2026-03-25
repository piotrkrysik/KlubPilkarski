package club.repository.data;

import club.model.Coach;
import club.repository.CoachDao;
import club.repository.PlayerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataCoachDao implements CoachDao {
    private final CoachRepository repository;

    @Override
    public List<Coach> findAll() {
        return repository.findAll();
    }

    @Override
    public Coach findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Coach add(Coach d) {
        return repository.save(d);
    }
}
