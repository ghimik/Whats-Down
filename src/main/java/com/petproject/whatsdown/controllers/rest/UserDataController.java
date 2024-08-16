package com.petproject.whatsdown.controllers.rest;

import com.petproject.whatsdown.services.UserDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class UserDataController {

    @Autowired private UserDataManagementService userDataManagementService;

    @GetMapping("/user")
    public ResponseEntity<Object> user() {
        Object principal;
        try {
            principal = userDataManagementService.getCurrentUserSecuredPrincipal();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        System.out.println("ok!: " + principal);
        return ResponseEntity.ok(principal);
    }
}
