package com.example.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by msnikitin on 20.04.2017.
 */
@RestController
public class HomeController {

    @Autowired
    OAuth2RestTemplate megaapiRestTemplate;

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object megaapi(Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity response = megaapiRestTemplate.exchange("http://localhost:8082/api/foo",
                HttpMethod.GET,
                request,
                String.class);

        return "\"" + response.getBody() + "\"";
    }

    @RequestMapping(value = "/api/test2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object megaapi2(Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity response = megaapiRestTemplate.exchange("http://localhost:8082/api/foo",
                HttpMethod.POST,
                request,
                String.class);

        return "\"" + response.getBody() + "\"";
    }
}
