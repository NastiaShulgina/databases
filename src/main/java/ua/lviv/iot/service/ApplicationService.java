package ua.lviv.iot.service;

import ua.lviv.iot.model.Application;

import java.util.List;

public interface ApplicationService {

    Application createApplication(Application application);

    List<Application> getAllApplications();

    Application getApplicationById(Integer id);

    Application updateApplication(Application application);

    Application deleteApplicationById(Integer id);
}
