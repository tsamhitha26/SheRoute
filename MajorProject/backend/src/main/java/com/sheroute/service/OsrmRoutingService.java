package com.sheroute.service;

import com.sheroute.dto.LocationDto;
import com.sheroute.dto.RouteOptionDto;

import java.util.List;

public interface OsrmRoutingService {

    List<RouteOptionDto> findRoutes(LocationDto source, LocationDto destination);
}
