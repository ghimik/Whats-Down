package com.petproject.whatsdown.controllers.rest;

import com.petproject.whatsdown.dtos.LoginRequestDao;
import com.petproject.whatsdown.dtos.SignUpRequestDao;
import com.petproject.whatsdown.services.UserAuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @PostMapping("/signin")
    public ResponseEntity<Void> signIn(@RequestBody LoginRequestDao loginRequestDao) {
        var authenticationRequest = new UsernamePasswordAuthenticationToken(loginRequestDao.getUsername(),
                loginRequestDao.getPassword());

        // повторяющаяся логика, изменить!
        Authentication authentication = this.authenticationManager.authenticate(authenticationRequest);
        if (!authentication.isAuthenticated()) {
            throw new BadCredentialsException("Invalid login credentials");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("sign in ctx while logging in: " + SecurityContextHolder.getContext());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody SignUpRequestDao request) {
        try {
            userAuthenticationService.registerUser(request.getUsername(), request.getPassword());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        // повторяющаяся логика, изменить!
        var authenticationRequest = new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationRequest);
        if (!authentication.isAuthenticated()) {
            throw new BadCredentialsException("Invalid login credentials");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("static" + SecurityContextHolder.getContext());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
