package com.catering.in.CateringBusinessLogin.user;

import com.catering.in.CateringBusinessLogin.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class UserController {

    private final IUserService svc;
    UserController(IUserService svc) {
        this.svc = svc;
    }

    @GetMapping("/api/user/getById/{id}")
    private ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = svc.getUserById(id);
        log.info("user:: {}", user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/api/user")
    private String getUserById(@RequestBody User user) {
        svc.saveAll(user);
        return "Created";
    }

    @GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }

}
