package co.edu.ff.orders.user.services;

import co.edu.ff.orders.user.domain.*;
import co.edu.ff.orders.user.exceptions.UserAlreadyExistsException;
import co.edu.ff.orders.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServices {
    private final UserRepository repository;

    @Autowired
    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    public UserOperation createUser(Username username, Password password) {
        Optional<UserCreated> userExistence = repository.findByUsername(username);
        if(userExistence.isPresent()){
            UserAlreadyExistsException exception = UserAlreadyExistsException.of(username);
            return UserOperationFailure.of(exception);
        } else {
            UserCreated userCreated = repository.createOne(username, password);
            return UserOperationSuccess.of(userCreated);
        }

    }

    public Optional<UserCreated> findById(Long id) {
        return repository.findById(id);
    }

}
