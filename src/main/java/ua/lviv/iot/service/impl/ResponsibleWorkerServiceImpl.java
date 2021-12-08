package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.ResponsibleWorkerDao;
import ua.lviv.iot.exception.EntityAlreadyExistsException;
import ua.lviv.iot.exception.ForeignKeyConstraintException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.ResponsibleWorker;
import ua.lviv.iot.service.ResponsibleWorkerService;

import java.util.List;

@Service
@AllArgsConstructor
public class ResponsibleWorkerServiceImpl implements ResponsibleWorkerService {

    private final ResponsibleWorkerDao responsibleWorkerDao;
    private final CallHasRescueVehicleDao callHasRescueVehicleDao;

    @Override
    public ResponsibleWorker createResponsibleWorker(ResponsibleWorker responsibleWorker) {
        String id = responsibleWorker.getNumber();
        if (responsibleWorkerDao.existsById(id)) {
            throw new EntityAlreadyExistsException("Entity with id: " + id + " already exists");
        }
        return responsibleWorkerDao.save(responsibleWorker);
    }

    @Override
    public List<ResponsibleWorker> getAllResponsibleWorkers() {
        return responsibleWorkerDao.findAll();
    }

    @Override
    public ResponsibleWorker getResponsibleWorkerById(String number) {
        return responsibleWorkerDao.findById(number)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + number + " not found"));
    }

    @Override
    public ResponsibleWorker updateResponsibleWorker(ResponsibleWorker responsibleWorker) {
        getResponsibleWorkerById(responsibleWorker.getNumber()); // throws exception if entity doesn't exist
        return responsibleWorkerDao.save(responsibleWorker);
    }

    /**
     * Deletes only if there is no foreign key associations
     */
    @Override
    public ResponsibleWorker deleteResponsibleWorkerById(String number) {
        ResponsibleWorker oldResponsibleWorker = getResponsibleWorkerById(number); // throws runtime exception if not found by id
        if (callHasRescueVehicleDao.countCallHasRescueVehiclesByRescueVehicle_Number(number) > 0) {
            throw new ForeignKeyConstraintException("Unable to delete this entity because its id is used in child table");
        }
        responsibleWorkerDao.deleteById(number);
        return oldResponsibleWorker;
    }
}
