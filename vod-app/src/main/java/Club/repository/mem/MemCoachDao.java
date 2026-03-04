package Club.repository.mem;

import Club.repository.CoachDao;
import Club.model.Coach;
import org.springframework.stereotype.Component;

import java.util.List;

// Zmieniono nazwę klasy z MemDirectorDao na MemCoachDao
@Component
public class MemCoachDao implements CoachDao {

    @Override
    public List<Coach> findAll() {
        // Zakładamy zmianę nazwy listy w SampleData z directors na coaches
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
        // Pobieramy najwyższe ID, aby nadać kolejne nowemu trenerowi
        // Używamy orElse(0) na wypadek, gdyby lista była pusta
        int max = SampleData.coaches.stream()
                .mapToInt(Coach::getId)
                .max()
                .orElse(0);

        coach.setId(++max);
        SampleData.coaches.add(coach);
        return coach;
    }
}