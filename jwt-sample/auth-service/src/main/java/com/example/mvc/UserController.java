package com.example.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by msnikitin on 24.04.2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping("principal.json")
    //@PreAuthorize("#oauth2.hasScope('read')")
    public Principal user(Principal user) {
        return user;
    }
}
