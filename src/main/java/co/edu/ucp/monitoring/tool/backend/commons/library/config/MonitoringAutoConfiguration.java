package co.edu.ucp.monitoring.tool.backend.commons.library.config;

import co.edu.ucp.monitoring.tool.backend.commons.library.controller.HealthController;
import co.edu.ucp.monitoring.tool.backend.commons.library.controller.MetricsController;
import co.edu.ucp.monitoring.tool.backend.commons.library.service.SystemMetricsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration class for the Monitoring Tool Commons Library.
 * <p>
 * Provides beans for system metrics service, health controller, and metrics controller.
 * This allows any Spring Boot application that includes this library to automatically
 * expose /health and /metrics endpoints.
 */
@Configuration
public class MonitoringAutoConfiguration {

    /**
     * Default constructor.
     */
    public MonitoringAutoConfiguration() {
        super();
    }

    /**
     * Provides a SystemMetricsService bean.
     *
     * @return a new SystemMetricsService instance
     */
    @Bean
    public SystemMetricsService systemMetricsService() {
        return new SystemMetricsService();
    }

    /**
     * Provides a HealthController bean.
     *
     * @return a new HealthController instance
     */
    @Bean
    public HealthController healthController() {
        return new HealthController();
    }

    /**
     * Provides a MetricsController bean using the provided SystemMetricsService.
     *
     * @param systemMetricsService the service used to collect system metrics
     * @return a new MetricsController instance
     */
    @Bean
    public MetricsController metricsController(SystemMetricsService systemMetricsService) {
        return new MetricsController(systemMetricsService);
    }
}
