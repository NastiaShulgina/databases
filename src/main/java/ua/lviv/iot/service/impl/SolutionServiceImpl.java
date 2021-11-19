package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.SolutionDaoImpl;
import ua.lviv.iot.model.Solution;

public class SolutionServiceImpl extends AbstractServiceImpl<Solution, String> {
    public SolutionServiceImpl() {
        super(new SolutionDaoImpl());
    }
}
