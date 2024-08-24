package com.petproject.whatsdown.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/register")
public class RegisterPageController {

    @GetMapping
    public String registerPage() {
        return "RegisterPage";
    }


}
