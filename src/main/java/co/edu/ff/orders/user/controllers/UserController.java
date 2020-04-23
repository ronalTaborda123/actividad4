package co.edu.ff.orders.user.controllers;

import co.edu.ff.orders.user.domain.CreateUserRequest;
import co.edu.ff.orders.user.domain.UserCreated;
import co.edu.ff.orders.user.domain.UserOperation;
import co.edu.ff.orders.user.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServices services;

    @PostMapping
    public ResponseEntity<UserOperation> createUser(@RequestBody CreateUserRequest userBody) {
        UserOperation userOperation = services.createUser(userBody.getUsername(), userBody.getPassword());
        if(userOperation.isValid()) {
            return ResponseEntity.ok(userOperation);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(userOperation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCreated> getUserById(@PathVariable Long id) {
        Optional<UserCreated> optionalUser = services.findById(id);
        return ResponseEntity.of(optionalUser);
    }
}
