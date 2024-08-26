package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.ChatMessageEntity;
import com.petproject.whatsdown.model.ChatRoom;
import com.petproject.whatsdown.model.ContactEntity;
import com.petproject.whatsdown.repository.ChatMessageRepository;
import com.petproject.whatsdown.repository.ContactRepository;
import com.petproject.whatsdown.repository.UserRepository;
import com.petproject.whatsdown.util.chatting.ChatData;
import com.petproject.whatsdown.util.chatting.ChatMessageData;
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
    public Collection<ChatData> getAllChats(UserDetails userDetails) {
        Collection<ContactEntity> contactEntities = contactRepository
                .findAll(userRepository
                        .findByUsername(userDetails.getUsername())
                        .getId()
                );

        return contactEntities
                .stream()
                .filter(contact -> contact.getChatRoom() != null)
                .map(contactEntity -> new ChatData(userDetails, contactEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Stream<ChatMessageData> getAllMessagesBetween(String firstUsername, String secondUsername) {

        System.out.println(firstUsername + "  " + secondUsername);

        ContactEntity contactEntity = contactRepository.findByFirstAndSecondOrSecondAndFirst(
                userRepository.findByUsername(firstUsername).getId(),
                userRepository.findByUsername(secondUsername).getId()
        );

        return chatMessageRepository
                .findAllByChatRoom(contactEntity.getChatRoom())
                .map(chatMessageEntity ->
                        new ChatMessageData(chatMessageEntity.getText(),
                                chatMessageEntity.getSender(),
                                contactEntity.getFirst().equals(chatMessageEntity.getSender()) ?
                                contactEntity.getSecond() : contactEntity.getFirst(),
                                contactEntity.getChatRoom().getId())
                );
    }

    @Override
    public void saveMessage(ChatMessageData message, String firstUsername, String secondUsername) {
        ContactEntity contactEntity = contactRepository.findByFirstAndSecondOrSecondAndFirst(
                userRepository.findByUsername(firstUsername).getId(),
                userRepository.findByUsername(secondUsername).getId()
        );

        ChatRoom chatRoom = contactEntity.getChatRoom();
        ChatMessageEntity messageEntity = new ChatMessageEntity();
        messageEntity.setText(message.getText());
        messageEntity.setChatRoom(chatRoom);
        messageEntity.setSender(userRepository.findByUsername(message.getSender().getUsername()));
        chatMessageRepository.saveAndFlush(messageEntity);


    }
}
