package com.sheroute.service;

import com.sheroute.dto.LocationDto;
import com.sheroute.dto.RouteResponse;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final GeocodingService geocodingService;
    private final OsrmRoutingService routingService;

    public RouteService(GeocodingService geocodingService, OsrmRoutingService routingService) {
        this.geocodingService = geocodingService;
        this.routingService = routingService;
    }

    public RouteResponse generateRoutes(String sourceName, String destinationName) {
        LocationDto source = geocodingService.geocode(sourceName);
        LocationDto destination = geocodingService.geocode(destinationName);
        return new RouteResponse(source, destination, routingService.findRoutes(source, destination));
    }
}
