package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Location;
import ua.lviv.iot.service.impl.LocationServiceImpl;

public class LocationControllerImpl extends AbstractControllerImpl<Location, Integer> {
    public LocationControllerImpl() {
        super(new LocationServiceImpl());
    }
}
