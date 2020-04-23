package co.edu.ff.orders.configuration.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database")
@RequiredArgsConstructor
@Data
public class DatabaseCredentials {
    private String host;
    private String port;
    private String username;
    private String password;
    private String database;
}


