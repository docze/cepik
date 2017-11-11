package com.mwsi.cepik.api.controller.user;

import com.mwsi.cepik.border.guards.User;
import com.mwsi.cepik.border.guards.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "api/register", method = RequestMethod.PUT)
    public User register(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(path = "secured", method = RequestMethod.GET)
    public String secured(Authentication auth){
        return "Logged user:" + auth.getName();
    }
}
