package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.LocationDaoImpl;
import ua.lviv.iot.model.Location;

public class LocationServiceImpl extends AbstractServiceImpl<Location, Integer> {
    public LocationServiceImpl() {
        super(new LocationDaoImpl());
    }
}
