package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.ProblemDaoImpl;
import ua.lviv.iot.model.Problem;

public class ProblemServiceImpl extends AbstractServiceImpl<Problem, Integer> {
    public ProblemServiceImpl() {
        super(new ProblemDaoImpl());
    }
}
