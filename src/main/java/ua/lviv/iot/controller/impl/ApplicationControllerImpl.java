package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Application;
import ua.lviv.iot.service.impl.ApplicationServiceImpl;

public class ApplicationControllerImpl extends AbstractControllerImpl<Application, Integer> {
    public ApplicationControllerImpl() {
        super(new ApplicationServiceImpl());
    }
}
