package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Problem;
import ua.lviv.iot.service.impl.ProblemServiceImpl;

public class ProblemControllerImpl extends AbstractControllerImpl<Problem, Integer> {
    public ProblemControllerImpl() {
        super(new ProblemServiceImpl());
    }
}
