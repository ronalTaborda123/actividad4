package co.edu.ff.orders.user.exceptions;

import co.edu.ff.orders.user.domain.Username;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class UserAlreadyExistsException extends UserException {
    Username username;

    private UserAlreadyExistsException(Username username) {
        super(String.format("User %s already exists", username.getValue()));
        this.username = username;
    }
}
