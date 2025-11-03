package co.edu.ucp.monitoring.tool.backend.commons.library.controller;

import co.edu.ucp.monitoring.tool.backend.commons.library.service.SystemMetricsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller that exposes the /metrics endpoint to provide system and JVM metrics.
 */
@RestController
public class MetricsController {

    private final SystemMetricsService systemMetricsService;

    /**
     * Constructs a MetricsController with the given SystemMetricsService.
     *
     * @param systemMetricsService the service used to collect system metrics
     */
    public MetricsController(SystemMetricsService systemMetricsService) {
        this.systemMetricsService = systemMetricsService;
    }

    /**
     * Returns a Map containing metrics such as CPU load, memory usage, OS information, JVM uptime, and timestamp.
     *
     * @return a Map of system and JVM metrics
     */
    @GetMapping("/monitoring-commons/metrics")
    public Map<String, Object> metrics() {
        return systemMetricsService.collectMetrics();
    }
}
