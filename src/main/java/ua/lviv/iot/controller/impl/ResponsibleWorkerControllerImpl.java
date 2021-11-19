package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.ResponsibleWorker;
import ua.lviv.iot.service.impl.ResponsibleWorkerServiceImpl;

public class ResponsibleWorkerControllerImpl extends AbstractControllerImpl<ResponsibleWorker, Integer> {
    public ResponsibleWorkerControllerImpl() {
        super(new ResponsibleWorkerServiceImpl());
    }
}
