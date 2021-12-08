package ua.lviv.iot.service;

import ua.lviv.iot.model.ResponsibleWorker;

import java.util.List;

public interface ResponsibleWorkerService {

    ResponsibleWorker createResponsibleWorker(ResponsibleWorker responsibleWorker);

    List<ResponsibleWorker> getAllResponsibleWorkers();

    ResponsibleWorker getResponsibleWorkerById(String number);

    ResponsibleWorker updateResponsibleWorker(ResponsibleWorker responsibleWorker);

    ResponsibleWorker deleteResponsibleWorkerById(String number);
}
