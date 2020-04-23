package co.edu.ff.orders.user.domain;

import co.edu.ff.orders.common.Preconditions;
import lombok.Value;

@Value(staticConstructor = "from")
public class UserAuthRequest {
    Username username;
    String password;

    public UserAuthRequest(Username username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);
        this.username = username;
        this.password = password;
    }
}
