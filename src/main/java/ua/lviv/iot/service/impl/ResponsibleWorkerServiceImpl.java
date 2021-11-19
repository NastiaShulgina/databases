package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.ResponsibleWorkerDaoImpl;
import ua.lviv.iot.model.ResponsibleWorker;

public class ResponsibleWorkerServiceImpl extends AbstractServiceImpl<ResponsibleWorker, Integer> {
    public ResponsibleWorkerServiceImpl() {
        super(new ResponsibleWorkerDaoImpl());
    }
}
