package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Application;

@Repository
public interface ApplicationDao extends JpaRepository<Application, Integer> {
}
