package com.mwsi.cepik.border.guards.appuser;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "users/registration")
    public User register(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(path = "secured", method = RequestMethod.GET)
    public String secured(Authentication auth){
        return "Logged user:" + auth.getName();
    }
}
