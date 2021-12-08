package ua.lviv.iot.service;

import ua.lviv.iot.dto.location.CreateUpdateLocationDto;
import ua.lviv.iot.model.Location;

import java.util.List;

public interface LocationService {

    Location createLocation(CreateUpdateLocationDto createUpdateLocationDto);

    List<Location> getAllLocations();

    Location getLocationById(Integer id);

    Location updateLocation(CreateUpdateLocationDto createUpdateLocationDto);

    Location deleteLocationById(Integer id);
}
