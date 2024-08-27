package com.petproject.whatsdown.controller.rest;

import com.petproject.whatsdown.dto.LoginRequestDao;
import com.petproject.whatsdown.dto.SignUpRequestDao;
import com.petproject.whatsdown.service.UserAuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// возможность удалить ебучий аккоунт

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    private SecurityContextRepository securityContextRepository;

    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody LoginRequestDao loginRequestDao,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        var authenticationRequest = new UsernamePasswordAuthenticationToken(loginRequestDao.getUsername(),
                loginRequestDao.getPassword());

        // повторяющаяся логика, изменить!
        //
        Authentication authentication = this.authenticationManager.authenticate(authenticationRequest);

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextRepository.saveContext(context, request, response);

        System.out.println("sign in ctx while logging in: " + SecurityContextHolder.getContext());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody SignUpRequestDao signUpRequestDao,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        try {
            userAuthenticationService.registerUser(signUpRequestDao.getUsername(),
                    signUpRequestDao.getPassword());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        // повторяющаяся логика, изменить!
        var authenticationRequest = new UsernamePasswordAuthenticationToken(signUpRequestDao.getUsername(),
                signUpRequestDao.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationRequest);

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextRepository.saveContext(context, request, response);

        System.out.println("in reg: " + SecurityContextHolder.getContext());

        return ResponseEntity.ok().build();
    }
}
