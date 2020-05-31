package com.catering.in.CateringBusinessLogin.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    private final IUserService svc;
    UserController(IUserService svc) {
        this.svc = svc;
    }

    @GetMapping("user/getById/{id}")
    private User getUserById(@PathVariable Integer id) {
        User user = svc.getUserById(id);
        log.info("user:: {}", user);
        return user;
    }


}
