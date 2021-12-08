package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.location.LocationDto;
import ua.lviv.iot.model.Location;

import java.util.Collections;
import java.util.stream.Collectors;

public class LocationMapper {

    private LocationMapper() {
    }

    public static LocationDto mapLocationToLocationDto(Location location) {
        return new LocationDto(
                location.getId(),
                location.getCity(),
                location.getStreet(),
                location.getOffice(),
                location.getRoomNumber(),
                location.getWorkplaceNumber()

        );
    }
}
