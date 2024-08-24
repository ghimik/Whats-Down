package com.petproject.whatsdown.controller.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomePageController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public String home() {
        System.out.println("sign in in home :" + SecurityContextHolder.getContext());
        return "HomePage";
    }
}
