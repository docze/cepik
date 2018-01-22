package com.mwsi.cepik.border.guards.appuser;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

public class UserController {

    @RequestMapping(path = "secured", method = RequestMethod.GET)
    public String secured(Authentication auth) {
        return "Logged user:" + auth.getName();
    }
}
