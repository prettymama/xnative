package xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class App {
	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
		try {
			Thread.currentThread().join();
		}
		catch (final Throwable ex) {
			throw new RuntimeException(ex);
		}
	}
}
