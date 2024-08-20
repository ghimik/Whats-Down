package com.petproject.whatsdown.controller.rest;

import com.petproject.whatsdown.service.ContactService;
import com.petproject.whatsdown.service.UserDataManagementService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private UserDataManagementService userDataManagementService;

    @Autowired private ContactService contactService;

    // дублирование логики

    @PostMapping("/add/{username}")
    public ResponseEntity<Void> add(@PathVariable String username) {
        try {
            contactService.addContact(
                    userDataManagementService.getCurrentUser().getUsername(),
                    username
            );
        }
        catch (AuthenticationException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove/{username}")
    public ResponseEntity<Void> remove(@PathVariable String username) {
        try {
            contactService.removeContact(
                    userDataManagementService.getCurrentUser().getUsername(),
                    username
            );
        }
        catch (AuthenticationException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


}
