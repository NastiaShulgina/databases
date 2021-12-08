package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.ResponsibleWorker;

@Repository
public interface ResponsibleWorkerDao extends JpaRepository<ResponsibleWorker, String> {
}
