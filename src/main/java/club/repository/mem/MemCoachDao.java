package club.repository.mem;

import club.repository.CoachDao;
import club.model.Coach;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("coachDao")
public class MemCoachDao implements CoachDao {

    @Override
    public List<Coach> findAll() {
        return SampleData.coaches;
    }

    @Override
    public Coach findById(int id) {
        return SampleData.coaches.stream()
                .filter(coach -> coach.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Coach add(Coach coach) {
        int max = SampleData.coaches.stream()
                .mapToInt(Coach::getId)
                .max()
                .orElse(0);

        coach.setId(++max);
        SampleData.coaches.add(coach);
        return coach;
    }
}