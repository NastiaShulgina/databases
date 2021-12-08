package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.problem.ProblemDto;
import ua.lviv.iot.mappers.ProblemMapper;
import ua.lviv.iot.model.Problem;
import ua.lviv.iot.service.ProblemService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.ProblemMapper.mapProblemToProblemDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/problem")
public class ProblemController {

    private final ProblemService problemService;

    @PostMapping
    ProblemDto createProblem(final @Valid @RequestBody Problem problem) {
        return mapProblemToProblemDto(problemService.createProblem(problem));
    }

    @GetMapping
    List<ProblemDto> getAllProblems() {
        return problemService.getAllProblems().stream()
                .map(ProblemMapper::mapProblemToProblemDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    ProblemDto getProblemById(final @PathVariable("id") Integer id) {
        return mapProblemToProblemDto(problemService.getProblemById(id));
    }

    @PutMapping
    ProblemDto updateProblem(final @Valid @RequestBody Problem problem) {
        return mapProblemToProblemDto(problemService.updateProblem(problem));
    }

    @DeleteMapping("/{id}")
    ProblemDto deleteProblemById(final @PathVariable("id") Integer id) {
        return mapProblemToProblemDto(problemService.deleteProblemById(id));
    }
}
