package co.edu.ff.orders.user.repositories;

import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.UserCreated;
import co.edu.ff.orders.user.domain.Username;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class SqlUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;


    public SqlUserRepository(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
    }


    private final RowMapper<UserCreated> rowMapper = (resultSet, i) -> {
        Long id1 = resultSet.getLong("ID");
        Username username = Username.of(resultSet.getString("USERNAME"));
        Password password = Password.of(resultSet.getString("PASSWORD"));
        return UserCreated.of(username, password, id1);
    };


    @Override
    public UserCreated createOne(Username username, Password password) {
        /*String SQL = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder(); // inicializada {}
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username.getValue());
            ps.setString(2, password.getValue());
            return ps;
        };

        jdbcTemplate.update(
                psc,
                keyHolder // --> {}, {1}
        );

        long key = keyHolder.getKey().longValue();*/
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("USERNAME", username.getValue());
        parameters.put("PASSWORD", password.getValue());

        Number number = simpleJdbcInsert.executeAndReturnKey(parameters);
        long id = number.longValue();
        return UserCreated.of(
                username,
                password,
                id
        );
    }

    @Override
    public Optional<UserCreated> findById(Long id) {
        String SQL = "SELECT ID, USERNAME, PASSWORD FROM USERS WHERE  ID = ?";
        Object[] objects = {id};

        try {
            UserCreated userCreated = jdbcTemplate.queryForObject(SQL, objects, rowMapper);
            return Optional.ofNullable(userCreated);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserCreated> findByUsername(Username username) {
        String SQL = "SELECT ID, USERNAME, PASSWORD FROM USERS WHERE USERNAME = ?";
        Object[] objects = {username.getValue()};
        try {
            UserCreated userCreated = jdbcTemplate.queryForObject(SQL, objects, rowMapper);
            return Optional.ofNullable(userCreated);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
