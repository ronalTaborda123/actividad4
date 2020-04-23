package co.edu.ff.orders.user.controllers;

import co.edu.ff.orders.user.domain.UserAuthRequest;
import co.edu.ff.orders.user.domain.Username;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @GetMapping("/hello")
    public String greeting() {
        return "Hello world";
    }


    @PostMapping("/authenticate")
    public UserAuthRequest authenticate() {
        Username username = Username.of("test-username");
        String password = "password...";
        return UserAuthRequest.from(
                username,
                password
        );
    }
}
