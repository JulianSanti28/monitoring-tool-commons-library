package co.edu.ucp.monitoring.tool.backend.commons.library.config;

import co.edu.ucp.monitoring.tool.backend.commons.library.service.SystemMetricsService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Auto-configuration class for the Monitoring Tool Commons Library.
 * <p>
 * Automatically exposes /health and /metrics endpoints in any Spring Boot web application.
 */
@AutoConfiguration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ComponentScan(basePackages = "co.edu.ucp.monitoring.tool.backend.commons.library.controller")
public class MonitoringAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SystemMetricsService systemMetricsService() {
        return new SystemMetricsService();
    }
}