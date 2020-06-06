package com.catering.in.CateringBusinessLogin.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class UserController {

    private final IUserService svc;
    UserController(IUserService svc) {
        this.svc = svc;
    }

    @GetMapping("user/getById/{id}")
    private ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = svc.getUserById(id);
        log.info("user:: {}", user);
        return ResponseEntity.ok().body(user);
    }


}
