package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.ApplicationDao;
import ua.lviv.iot.exception.ForeignKeyConstraintException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Application;
import ua.lviv.iot.service.ApplicationService;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationDao applicationDao;

    @Override
    public Application createApplication(Application application) {
        return applicationDao.save(application);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationDao.findAll();
    }

    @Override
    public Application getApplicationById(Integer id) {
        return applicationDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Application updateApplication(Application application) {
        getApplicationById(application.getId()); // throws exception if entity doesn't exist
        return applicationDao.save(application);
    }

    /**
     * Deletes only if there is no foreign key associations
     */
    @Override
    public Application deleteApplicationById(Integer id) {
        Application oldApplication = getApplicationById(id); // throws runtime exception if not found by id
        try {
            applicationDao.deleteById(id);
        } catch (Exception e) {
            throw new ForeignKeyConstraintException("Unable to delete this entity because its id is used in child table");
        }
        return oldApplication;
    }
}
