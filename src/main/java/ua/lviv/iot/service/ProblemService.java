package ua.lviv.iot.service;

import ua.lviv.iot.model.Problem;

import java.util.List;

public interface ProblemService {

    Problem createProblem(Problem problem);

    List<Problem> getAllProblems();

    Problem getProblemById(Integer id);

    Problem updateProblem(Problem problem);

    Problem deleteProblemById(Integer id);
}
