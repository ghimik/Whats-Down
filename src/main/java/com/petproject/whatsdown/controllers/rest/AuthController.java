package com.petproject.whatsdown.controllers.rest;

import com.petproject.whatsdown.dtos.SignUpRequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<Void> signIn(@RequestBody SignUpRequestDao request) {
        var authenticationRequest = new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationRequest);
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            throw new BadCredentialsException("Invalid login credentials");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody SignUpRequestDao request) {
        return ResponseEntity.ok("adsfa");
    }

}
