package co.edu.ff.orders.user.repositories;

import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.UserCreated;
import co.edu.ff.orders.user.domain.Username;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ImMemoryUserRepository implements UserRepository {
    private final Map<Long, UserCreated> state = new HashMap<>();


    @Override
    public UserCreated createOne(Username username, Password password) {
        Long id = state.size() + 1L;
        UserCreated userCreated = UserCreated.of(username, password, id);
        state.put(id, userCreated);
        return userCreated;
    }

    @Override
    public Optional<UserCreated> findById(Long id) {
        return Optional.ofNullable(state.get(id));
    }

    @Override
    public Optional<UserCreated> findByUsername(Username username) {
        return Optional.empty();
    }


}
