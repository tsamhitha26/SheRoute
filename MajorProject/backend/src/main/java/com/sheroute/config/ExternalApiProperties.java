package com.sheroute.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "external-apis")
public record ExternalApiProperties(
        Nominatim nominatim,
        Osrm osrm,
        Duration connectTimeout,
        Duration readTimeout
) {
    public ExternalApiProperties {
        if (nominatim == null) {
            nominatim = new Nominatim("https://nominatim.openstreetmap.org", "SheRouteMajorProject/1.0", "sheroute@example.com");
        }
        if (osrm == null) {
            osrm = new Osrm("https://router.project-osrm.org");
        }
        if (connectTimeout == null) {
            connectTimeout = Duration.ofSeconds(5);
        }
        if (readTimeout == null) {
            readTimeout = Duration.ofSeconds(10);
        }
    }

    public record Nominatim(String baseUrl, String userAgent, String email) {
    }

    public record Osrm(String baseUrl) {
    }
}
