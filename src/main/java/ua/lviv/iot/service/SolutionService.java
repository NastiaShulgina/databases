package ua.lviv.iot.service;

import ua.lviv.iot.model.Solution;

import java.util.List;

public interface SolutionService {

    Solution createSolution(Solution solution);

    List<Solution> getAllSolutions();

    Solution getSolutionById(String id);

    Solution updateSolution(Solution solution);

    Solution deleteSolutionById(String id);
}
