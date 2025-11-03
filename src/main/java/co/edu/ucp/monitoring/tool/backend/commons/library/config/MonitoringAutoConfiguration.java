package co.edu.ucp.monitoring.tool.backend.commons.library.config;

import co.edu.ucp.monitoring.tool.backend.commons.library.controller.HealthController;
import co.edu.ucp.monitoring.tool.backend.commons.library.controller.MetricsController;
import co.edu.ucp.monitoring.tool.backend.commons.library.service.SystemMetricsService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration class for the Monitoring Tool Commons Library.
 *
 * Provides beans for system metrics service, health controller, and metrics controller.
 * This allows any Spring Boot application that includes this library to automatically
 * expose /health and /metrics endpoints.
 */
@Configuration
public class MonitoringAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(MonitoringAutoConfiguration.class);

    @PostConstruct
    public void init() {
        log.info("🚀✨ Exponiendo servicios de monitoreo desde Commons Library 🛠️🔍");
        log.info("💚 Endpoints disponibles: /health 🩺, /metrics 📊");
    }

    /**
     * Provides a SystemMetricsService bean.
     */
    @Bean
    public SystemMetricsService systemMetricsService() {
        return new SystemMetricsService();
    }

    /**
     * Provides a HealthController bean.
     */
    @Bean
    public HealthController healthController() {
        return new HealthController();
    }

    /**
     * Provides a MetricsController bean using the provided SystemMetricsService.
     */
    @Bean
    public MetricsController metricsController(SystemMetricsService systemMetricsService) {
        return new MetricsController(systemMetricsService);
    }
}
