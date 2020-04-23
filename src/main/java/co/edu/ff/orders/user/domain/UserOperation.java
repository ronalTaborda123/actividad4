package co.edu.ff.orders.user.domain;

public interface UserOperation {
    UserCreated value();
    String errorMessage();

    Boolean isValid();
}
