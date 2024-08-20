package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.ChatMessageEntity;
import com.petproject.whatsdown.model.ChatRoom;
import com.petproject.whatsdown.model.Contact;
import com.petproject.whatsdown.repository.ChatMessageRepository;
import com.petproject.whatsdown.repository.ContactRepository;
import com.petproject.whatsdown.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ChatMangingServiceImpl implements ChatMangingService {

    @Autowired private ContactRepository contactRepository;

    @Autowired private UserRepository userRepository;

    @Autowired private ChatMessageRepository chatMessageRepository;

    @Override
    public Collection<ChatRoom> getAllChats(UserDetails userDetails) {
        Collection<Contact> contacts = contactRepository
                .findAll(userRepository
                        .findByUsername(userDetails.getUsername())
                );

        return contacts
                .stream()
                .map(Contact::getChatRoom)
                .collect(Collectors.toList());
    }

    @Override
    public Stream<ChatMessageEntity> getAllMessagesBetween(String firstUsername, String secondUsername) {
        Contact contact = contactRepository.findByFirstAndSecondOrSecondAndFirst(
                userRepository.findByUsername(firstUsername),
                userRepository.findByUsername(secondUsername)
        );

        return chatMessageRepository
                .findAllByChatRoom(contact.getChatRoom());
    }
}
