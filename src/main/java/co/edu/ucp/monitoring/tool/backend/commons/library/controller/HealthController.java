package co.edu.ucp.monitoring.tool.backend.commons.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

/**
 * Controller that exposes the /health endpoint for checking service health status.
 */
@RestController
public class HealthController {

    /**
     * Default constructor.
     */
    public HealthController() {
        super();
    }

    /**
     * Returns the health status of the service.
     *
     * @return a Map containing the status and the current timestamp
     */
    @GetMapping("/monitoring-commons/health")
    public Map<String, Object> health() {
        return Map.of(
                "status", "UP",
                "timestamp", Instant.now().toString()
        );
    }
}
