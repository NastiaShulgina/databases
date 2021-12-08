package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.ProblemDao;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Problem;
import ua.lviv.iot.service.ProblemService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ProblemServiceImpl implements ProblemService {

    private final ProblemDao problemDao;

    @Override
    public Problem createProblem(Problem problem) {
        return problemDao.save(problem);
    }

    @Override
    public List<Problem> getAllProblems() {
        return problemDao.findAll();
    }

    @Override
    public Problem getProblemById(Integer id) {
        return problemDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Problem updateProblem(Problem problem) {
        getProblemById(problem.getId()); // will throw exception if entity doesn't exist
        return problemDao.save(problem);
    }

    @Override
    public Problem deleteProblemById(Integer id) {
        Problem problem = getProblemById(id); // throws runtime exception if not found by id
        for (Integer injuryId : injuryDao.findInjury_IdsByHospital_id(id)) { // removes all the associated injuries
            callHasRescuerDao.deleteCallHasRescuerByInjury_Id(injuryId);
            injuryDao.deleteById(injuryId);
        }
        problemDao.deleteById(id);
        return problem;
    }
}
