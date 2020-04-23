package co.edu.ff.orders.user.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class UserOperationSuccess implements UserOperation {
    UserCreated value;

    @Override
    public UserCreated value() {
        return value;
    }

    @Override
    public String errorMessage() {
        return null;
    }

    @Override
    public Boolean isValid() {
        return true;
    }
}
