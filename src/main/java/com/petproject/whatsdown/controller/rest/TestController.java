package com.petproject.whatsdown.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// убрать нахрееен
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping()
    public ResponseEntity<Object> test(@RequestBody Object text) {
        return ResponseEntity.ok(text);
    }
}
