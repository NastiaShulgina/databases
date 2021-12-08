package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.LocationDao;
import ua.lviv.iot.dto.location.CreateUpdateLocationDto;
import ua.lviv.iot.exception.InvalidDateTimeException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.model.Application;
import ua.lviv.iot.model.Solution;
import ua.lviv.iot.service.ApplicationService;
import ua.lviv.iot.service.LocationService;
import ua.lviv.iot.service.SolutionService;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationDao locationDao;
    private final SolutionService solutionService;
    private final ApplicationService applicationService;

    @Override
    public Location createLocation(CreateUpdateLocationDto createUpdateLocationDto) {
        Solution solution = solutionService.getSolutionById(createUpdateLocationDto.getSolutionId); // will throw exception if entity doesn't exist
        Application callAddress = applicationService.getApplicationById(createUpdateLocationDto.getApplicationId()); // will throw exception if entity doesn't exist
        LocalDateTime callTime;
        try {
            callTime = LocalDateTime.parse(createUpdateLocationDto.getCallTime());
        } catch (DateTimeException e) {
            throw new InvalidDateTimeException("enter valid datetime");
        }
        return locationDao.save(new Location(
                createUpdateLocationDto.getShortDescription(),
                createUpdateLocationDto.getDetailedDescription(),
                callTime,
                solution,
                callAddress
        ));
    }

    @Override
    public List<Location> getAllLocations() {
        return locationDao.findAll();
    }

    @Override
    public Location getLocationById(Integer id) {
        return locationDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Location updateLocation(CreateUpdateLocationDto createUpdateLocationDto) {
        getLocationById(createUpdateLocationDto.getId()); // will throw exception if entity doesn't exist
        Solution solution = solutionService.getSolutionById(createUpdateLocationDto.getReporterId()); // will throw exception if entity doesn't exist
        Application callAddress = applicationService.getApplicationById(createUpdateLocationDto.getCallAddressId()); // will throw exception if entity doesn't exist
        LocalDateTime callTime;
        try {
            callTime = LocalDateTime.parse(createUpdateLocationDto.getCallTime());
        } catch (DateTimeException e) {
            throw new InvalidDateTimeException("enter valid datetime");
        }
        return locationDao.save(new Location(
                createUpdateLocationDto.getId(),
                createUpdateLocationDto.getShortDescription(),
                createUpdateLocationDto.getDetailedDescription(),
                callTime,
                solution,
                callAddress
        ));
    }

    /**
     * Deletes with CascadeType=REMOVE
     */
    @Override
    public Location deleteLocationById(Integer id) {
        Location location = getLocationById(id); // throws runtime exception if not found by id
        locationDao.deleteById(id);
        return location;
    }
}
