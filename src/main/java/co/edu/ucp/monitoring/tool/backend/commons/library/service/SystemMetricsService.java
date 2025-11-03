package co.edu.ucp.monitoring.tool.backend.commons.library.service;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Service that collects system and JVM metrics for monitoring purposes.
 * <p>
 * Provides information such as CPU usage, memory usage, operating system details,
 * JVM uptime, and Java version.
 */
public class SystemMetricsService {

    private final OperatingSystemMXBean sunOsBean;

    /**
     * Constructs a new SystemMetricsService instance.
     * Initializes the OperatingSystemMXBean to collect system metrics.
     */
    public SystemMetricsService() {
        this.sunOsBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    }

    /**
     * Collects metrics from the system and JVM.
     *
     * @return a Map containing key metrics such as CPU load, memory usage, OS info, JVM uptime, and timestamp.
     */
    public Map<String, Object> collectMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        Runtime runtime = Runtime.getRuntime();

        // CPU metrics
        metrics.put("availableProcessors", sunOsBean.getAvailableProcessors());
        metrics.put("systemCpuLoadPercent", Math.round(sunOsBean.getCpuLoad() * 100));
        metrics.put("processCpuLoadPercent", Math.round(sunOsBean.getProcessCpuLoad() * 100));

        // Memory metrics
        metrics.put("totalMemoryMB", runtime.totalMemory() / (1024 * 1024));
        metrics.put("freeMemoryMB", runtime.freeMemory() / (1024 * 1024));
        metrics.put("usedMemoryMB", (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

        // Operating system information
        metrics.put("osName", sunOsBean.getName());
        metrics.put("osVersion", sunOsBean.getVersion());
        metrics.put("osArch", sunOsBean.getArch());

        // JVM and environment info
        metrics.put("uptimeSeconds", ManagementFactory.getRuntimeMXBean().getUptime() / 1000);
        metrics.put("javaVersion", System.getProperty("java.version"));
        metrics.put("timestamp", Instant.now().toString());

        return metrics;
    }
}
