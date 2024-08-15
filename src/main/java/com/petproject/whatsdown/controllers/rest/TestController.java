package com.petproject.whatsdown.controllers.rest;

import com.petproject.whatsdown.dtos.SignUpRequestDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping()
    public ResponseEntity<Object> test(@RequestBody Object text) {
        return ResponseEntity.ok(text);
    }
}
