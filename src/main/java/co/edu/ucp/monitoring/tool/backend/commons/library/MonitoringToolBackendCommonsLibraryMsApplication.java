package co.edu.ucp.monitoring.tool.backend.commons.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Monitoring Tool Commons Library Spring Boot application.
 * <p>
 * This class starts the Spring Boot application and enables all auto-configurations.
 */
@SpringBootApplication
public class MonitoringToolBackendCommonsLibraryMsApplication {

	/**
	 * Default constructor.
	 */
	public MonitoringToolBackendCommonsLibraryMsApplication() {
		super();
	}

	/**
	 * The entry point of the application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MonitoringToolBackendCommonsLibraryMsApplication.class, args);
	}
}
