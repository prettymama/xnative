package xxx;

import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("server")
@Validated
public record ServerConfiguration(@Min(1) int port) {}
