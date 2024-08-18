package com.petproject.whatsdown.controllers.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @Autowired
    private SecurityContextRepository securityContextRepository;

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.clearContext();
        SecurityContextHolder.setContext(context);
        securityContextRepository.saveContext(context, request, response);
        return "redirect: ";
    }
}
