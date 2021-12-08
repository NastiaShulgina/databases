package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Solution;

@Repository
public interface SolutionDao extends JpaRepository<Solution, String> {
}
