package co.edu.ff.orders.user.repositories;

import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.UserCreated;
import co.edu.ff.orders.user.domain.Username;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    UserCreated createOne(Username username, Password password);

    Optional<UserCreated> findById(Long id);

    Optional<UserCreated> findByUsername(Username username);
}
