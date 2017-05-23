package com.example.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

/**
 * Created by msnikitin on 20.04.2017.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @PreAuthorize("hasAuthority('ACTUATOR') and hasAuthority('FOO_READ') and #oauth2.hasScope('FOO') and #oauth2.isUser()")
    @GetMapping("foo")
    public String readFoo(Principal principal) {
        return "read foo " + UUID.randomUUID().toString();
    }

    @PreAuthorize("hasAuthority('FOO_WRITE') and #oauth2.hasScope('FOO') and #oauth2.isUser()")
    @PostMapping("foo")
    public String writeFoo(Principal principal) {
        return "write foo " + UUID.randomUUID().toString();
    }
}
