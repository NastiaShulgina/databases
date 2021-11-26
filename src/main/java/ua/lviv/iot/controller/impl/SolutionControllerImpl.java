package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Solution;
import ua.lviv.iot.service.impl.SolutionServiceImpl;

public class SolutionControllerImpl extends AbstractControllerImpl<Solution, String> {
    public SolutionControllerImpl() {
        super(new SolutionServiceImpl());
    }
}
