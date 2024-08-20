package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.ChatMessageEntity;
import com.petproject.whatsdown.model.ChatRoom;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Stream;

public interface ChatMangingService {

    Collection<ChatRoom> getAllChats(UserDetails userDetails);

    Stream<ChatMessageEntity> getAllMessagesBetween(String firstUsername, String secondUsername);
}
