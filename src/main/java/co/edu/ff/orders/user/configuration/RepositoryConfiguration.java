package co.edu.ff.orders.user.configuration;

import co.edu.ff.orders.product.repositories.ProductRepository;
import co.edu.ff.orders.product.repositories.SqlProductRepository;
import co.edu.ff.orders.user.repositories.ImMemoryUserRepository;
import co.edu.ff.orders.user.repositories.SqlUserRepository;
import co.edu.ff.orders.user.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @Profile({"dev", "prod"})
    public UserRepository userRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("USERS")
                .usingGeneratedKeyColumns("ID");

        return new SqlUserRepository(jdbcTemplate, simpleJdbcInsert);
    }

    @Bean
    @Profile({"dev", "prod"})
    public ProductRepository productRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("PRODUCTS")
                .usingGeneratedKeyColumns("ID");

        return new SqlProductRepository(jdbcTemplate, simpleJdbcInsert);
    }

    @Bean
    @Profile({"dev-test"})
    public UserRepository userRepository() {
        return new ImMemoryUserRepository();
    }
}
