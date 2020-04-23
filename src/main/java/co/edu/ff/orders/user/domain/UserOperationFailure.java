package co.edu.ff.orders.user.domain;

import co.edu.ff.orders.user.exceptions.UserException;
import lombok.Value;

@Value(staticConstructor = "of")
public class UserOperationFailure implements UserOperation {
    UserException exception;

    @Override
    public UserCreated value() {
        return null;
    }

    @Override
    public String errorMessage() {
        return exception.getMessage();
    }

    @Override
    public Boolean isValid() {
        return false;
    }
}
