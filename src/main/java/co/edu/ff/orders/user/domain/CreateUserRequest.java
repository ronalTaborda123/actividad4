package co.edu.ff.orders.user.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class CreateUserRequest {
    Username username;
    Password password;
}
