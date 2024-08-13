package com.petproject.whatsdown.controllers.mvc;

import com.petproject.whatsdown.dtos.SignUpRequestDao;
import com.petproject.whatsdown.models.User;
import com.petproject.whatsdown.services.UserAuthenticationService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/registration")
public class RegisterPageController {

    @Autowired private UserAuthenticationService userAuthenticationService;

    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerPage() {
        return "registerPage";
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody SignUpRequestDao dto) {
        var user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        try {
            userAuthenticationService.registerUser(user);
        } catch (Exception e) {
            return ResponseEntity.ok(Strings.EMPTY);
        }
        return ResponseEntity.badRequest().body(Strings.EMPTY);
    }
}
