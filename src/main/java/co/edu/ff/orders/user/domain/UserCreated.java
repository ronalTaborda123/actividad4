package co.edu.ff.orders.user.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class UserCreated {
    Username username;
    Password password;
    Long id;
}
