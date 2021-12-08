package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.responsibleworker.ResponsibleWorkerDto;
import ua.lviv.iot.mappers.ResponsibleWorkerMapper;
import ua.lviv.iot.model.ResponsibleWorker;
import ua.lviv.iot.service.ResponsibleWorkerService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.ResponsibleWorkerMapper.mapResponsibleWorkerToResponsibleWorkerDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/responsible-worker")
public class ResponsibleWorkerController {

    private final ResponsibleWorkerService responsibleWorkerService;

    @PostMapping
    ResponsibleWorkerDto createResponsibleWorker(final @Valid @RequestBody ResponsibleWorker responsibleWorker) {
        return mapResponsibleWorkerToResponsibleWorkerDto(responsibleWorkerService.createResponsibleWorker(responsibleWorker));
    }

    @GetMapping
    List<ResponsibleWorkerDto> getAllResponsibleWorkers() {
        return responsibleWorkerService.getAllResponsibleWorkers().stream()
                .map(ResponsibleWorkerMapper::mapResponsibleWorkerToResponsibleWorkerDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    ResponsibleWorkerDto getResponsibleWorkerById(final @PathVariable("id") String number) {
        return mapResponsibleWorkerToResponsibleWorkerDto(responsibleWorkerService.getResponsibleWorkerById(number));
    }

    @PutMapping
    ResponsibleWorkerDto updateResponsibleWorker(final @Valid @RequestBody ResponsibleWorker responsibleWorker) {
        return mapResponsibleWorkerToResponsibleWorkerDto(responsibleWorkerService.updateResponsibleWorker(responsibleWorker));
    }

    @DeleteMapping("/{id}")
    ResponsibleWorkerDto deleteResponsibleWorkerById(final @PathVariable("id") String number) {
        return mapResponsibleWorkerToResponsibleWorkerDto(responsibleWorkerService.deleteResponsibleWorkerById(number));
    }
}
