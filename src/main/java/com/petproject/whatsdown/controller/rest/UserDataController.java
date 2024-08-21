package com.petproject.whatsdown.controller.rest;

import com.petproject.whatsdown.dto.ChatDto;
import com.petproject.whatsdown.dto.ChatsDto;
import com.petproject.whatsdown.dto.ContactsDto;
import com.petproject.whatsdown.dto.UserDataDto;
import com.petproject.whatsdown.service.ChatMangingService;
import com.petproject.whatsdown.service.ContactService;
import com.petproject.whatsdown.service.UserDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;
import java.util.stream.Collectors;

// добавить не одностроннее добавление контактов, возможность кинуть в чс
// а так же понятия прочитанного или нет сообщения

@RestController
@RequestMapping("/data")
public class UserDataController {

    @Autowired private UserDataManagementService userDataManagementService;

    @Autowired private ContactService contactService;

    @Autowired private ChatMangingService chatMangingService;

    @GetMapping("/user")
    public ResponseEntity<UserDataDto> user() {
        return dtoByUserName(UserDataDto::new);
    }

    @GetMapping("/contacts")
    public ResponseEntity<ContactsDto> contacts() {
        return dtoByUserName(
                (username) -> new ContactsDto(contactService.getContacts(username))
                );
    }

    @GetMapping("/chats")
    public ResponseEntity<ChatsDto> chats() {
        return dtoByUserDetails(
                (userDetails) -> new ChatsDto(chatMangingService.getAllChats(userDetails))
        );

    }

    @GetMapping("/chat")
    public ResponseEntity<ChatDto> chat(@RequestParam String with) {
        return dtoByUserName(
                (username) ->
                        new ChatDto(chatMangingService
                                .getAllMessagesBetween(username, with)
                                .collect(Collectors.toList())
                        )
        );
    }

    private <T> ResponseEntity<T> dtoByUserDetails(Function<UserDetails, T> dtoCreator) {
        T dto;
        try {
            dto = dtoCreator.apply(userDataManagementService.getCurrentUser());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        System.out.println("ok!: " + dto);
        return ResponseEntity.ok(dto);
    }

    private <T> ResponseEntity<T> dtoByUserName(Function<String, T> dtoCreator) {
        return dtoByUserDetails(
                userDetails -> dtoCreator.apply(userDetails.getUsername())
        );
    }
}
