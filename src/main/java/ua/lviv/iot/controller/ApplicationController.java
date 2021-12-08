package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.application.ApplicationDto;
import ua.lviv.iot.mappers.ApplicationMapper;
import ua.lviv.iot.model.Application;
import ua.lviv.iot.service.ApplicationService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.ApplicationMapper.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    ApplicationDto createApplication(final @Valid @RequestBody Application application) {
        return mapApplicationToApplicationDto(applicationService.createApplication(application));
    }

    @GetMapping
    List<ApplicationDto> getAllApplications() {
        return applicationService.getAllApplications().stream()
                .map(ApplicationMapper::mapApplicationToApplicationDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    ApplicationDto getApplicationById(final @PathVariable("id") Integer id) {
        return mapApplicationToApplicationDto(applicationService.getApplicationById(id));
    }

    @PutMapping
    ApplicationDto updateApplication(final @Valid @RequestBody Application application) {
        return mapApplicationToApplicationDto(applicationService.updateApplication(application));
    }

    @DeleteMapping("/{id}")
    ApplicationDto deleteApplicationById(final @PathVariable("id") Integer id) {
        return mapApplicationToApplicationDto(applicationService.deleteApplicationById(id));
    }
}
