package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.solution.SolutionDto;
import ua.lviv.iot.mappers.SolutionMapper;
import ua.lviv.iot.model.Solution;
import ua.lviv.iot.service.SolutionService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.SolutionMapper.mapSolutionToSolutionDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/solution")
public class SolutionController {

    private final SolutionService solutionService;

    @PostMapping
    SolutionDto createSolution(final @Valid @RequestBody Solution solution) {
        return mapSolutionToSolutionDto(solutionService.createSolution(solution));
    }

    @GetMapping
    List<SolutionDto> getAllSolutions() {
        return solutionService.getAllSolutions().stream()
                .map(SolutionMapper::mapSolutionToSolutionDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    SolutionDto getSolutionById(final @PathVariable("id") String id) {
        return mapSolutionToSolutionDto(solutionService.getSolutionById(id));
    }

    @PutMapping
    SolutionDto updateSolution(final @Valid @RequestBody Solution solution) {
        return mapSolutionToSolutionDto(solutionService.updateSolution(solution));
    }

    @DeleteMapping("/{id}")
    SolutionDto deleteSolutionById(final @PathVariable("id") String id) {
        return mapSolutionToSolutionDto(solutionService.deleteSolutionById(id));
    }
}
