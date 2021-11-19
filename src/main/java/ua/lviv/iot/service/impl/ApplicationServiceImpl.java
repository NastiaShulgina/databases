package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.ApplicationDaoImpl;
import ua.lviv.iot.model.Application;

public class ApplicationServiceImpl extends AbstractServiceImpl<Application, Integer> {
    public ApplicationServiceImpl() {
        super(new ApplicationDaoImpl());
    }
}
