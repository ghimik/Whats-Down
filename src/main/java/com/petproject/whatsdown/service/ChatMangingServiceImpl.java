package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.ChatMessageEntity;
import com.petproject.whatsdown.model.ChatRoom;
import com.petproject.whatsdown.model.Contact;
import com.petproject.whatsdown.model.ContactEntity;
import com.petproject.whatsdown.repository.ChatMessageRepository;
import com.petproject.whatsdown.repository.ContactRepository;
import com.petproject.whatsdown.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ChatMangingServiceImpl implements ChatMangingService {

    @Autowired private ContactRepository contactRepository;

    @Autowired private UserRepository userRepository;

    @Autowired private ChatMessageRepository chatMessageRepository;

    @Override
    public Collection<Contact> getAllChats(UserDetails userDetails) {
        Collection<ContactEntity> contactEntities = contactRepository
                .findAll(userRepository
                        .findByUsername(userDetails.getUsername())
                );

        return contactEntities
                .stream()
                .filter(contact -> contact.getChatRoom() != null)
                .collect(Collectors.toList());
    }

    @Override
    public Stream<ChatMessageEntity> getAllMessagesBetween(String firstUsername, String secondUsername) {
        ContactEntity contactEntity = contactRepository.findByFirstAndSecondOrSecondAndFirst(
                userRepository.findByUsername(firstUsername),
                userRepository.findByUsername(secondUsername)
        );

        return chatMessageRepository
                .findAllByChatRoom(contactEntity.getChatRoom());
    }
}
