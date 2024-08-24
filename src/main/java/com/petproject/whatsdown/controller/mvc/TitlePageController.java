package com.petproject.whatsdown.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TitlePageController {

    @GetMapping("/")
    public String home() {
        return "TitlePage";
    }
}
