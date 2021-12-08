package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.location.LocationDto;
import ua.lviv.iot.dto.location.CreateUpdateLocationDto;
import ua.lviv.iot.mappers.LocationMapper;
import ua.lviv.iot.service.LocationService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.LocationMapper.mapLocationToLocationDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    LocationDto createLocation(final @Valid @RequestBody CreateUpdateLocationDto createUpdateLocationDto) {
        return mapLocationToLocationDto(locationService.createLocation(createUpdateLocationDto));
    }

    @GetMapping
    List<LocationDto> getAllLocations() {
        return locationService.getAllLocations().stream()
                .map(LocationMapper::mapLocationToLocationDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    LocationDto getLocationById(final @PathVariable("id") Integer id) {
        return mapLocationToLocationDto(locationService.getLocationById(id));
    }

    @PutMapping
    LocationDto updateLocation(final @Valid @RequestBody CreateUpdateLocationDto createUpdateLocationDto) {
        return mapLocationToLocationDto(locationService.updateLocation(createUpdateLocationDto));
    }

    @DeleteMapping("/{id}")
    LocationDto deleteLocationById(final @PathVariable("id") Integer id) {
        return mapLocationToLocationDto(locationService.deleteLocationById(id));
    }
}
