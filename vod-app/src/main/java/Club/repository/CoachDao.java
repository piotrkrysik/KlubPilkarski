package Club.repository;

import Club.model.Coach;

import java.util.List;

public interface CoachDao {

    List<Coach> findAll();

    Coach findById(int id);

    Coach add(Coach d);


}
