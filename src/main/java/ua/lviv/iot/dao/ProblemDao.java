package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Problem;

@Repository
public interface ProblemDao extends JpaRepository<Problem, Integer> {
}
