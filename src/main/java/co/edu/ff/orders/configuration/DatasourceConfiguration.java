package co.edu.ff.orders.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {

    @Bean
    @Profile({"test", "dev"})
    public DataSource testDatasource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:scripts/schema.sql")
                //.addScript("classpath:scripts/data.sql")
                .build();
    }



    /*@Bean
    public DataSource hikariDatasource(DatabaseCredentials credentials) {
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.addDataSourceProperty("databaseName", credentials.getDatabase());
        config.addDataSourceProperty("portNumber", credentials.getPort());
        config.addDataSourceProperty("serverName", credentials.getHost());
        config.setUsername(credentials.getUsername());
        config.setPassword(credentials.getPassword());
        return new HikariDataSource(config);
    }*/
}
