package com.petproject.whatsdown.controllers.mvc;

import com.petproject.whatsdown.dtos.SignUpRequestDao;
import com.petproject.whatsdown.models.User;
import com.petproject.whatsdown.services.UserAuthenticationService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/register")
public class RegisterPageController {

    @GetMapping
    public String registerPage() {
        return "registerPage";
    }


}
