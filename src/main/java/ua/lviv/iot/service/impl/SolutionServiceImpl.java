package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.SolutionDao;
import ua.lviv.iot.exception.EntityAlreadyExistsException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Solution;
import ua.lviv.iot.service.SolutionService;

import java.util.List;

@Service
@AllArgsConstructor
public class SolutionServiceImpl implements SolutionService {

    private final SolutionDao solutionDao;

    @Override
    public Solution createSolution(Solution solution) {
        String id = solution.getPhoneNumber();
        if (solutionDao.existsById(id)) {
            throw new EntityAlreadyExistsException("Entity with id: " + id + " already exists");
        }
        return solutionDao.save(solution);
    }

    @Override
    public List<Solution> getAllSolutions() {
        return solutionDao.findAll();
    }

    @Override
    public Solution getSolutionById(String phoneNumber) {
        return solutionDao.findById(phoneNumber)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + phoneNumber + " not found"));
    }

    @Override
    public Solution updateSolution(Solution solution) {
        getSolutionById(solution.getPhoneNumber());  // will throw exception if entity doesn't exist
        return solutionDao.save(solution);
    }

    /**
     * Deletes with CascadeType=REMOVE
     */
    @Override
    public Solution deleteSolutionById(String id) {
        Solution solution = getSolutionById(id); // throws runtime exception if not found by id
        solutionDao.deleteById(id);
        return solution;
    }
}
