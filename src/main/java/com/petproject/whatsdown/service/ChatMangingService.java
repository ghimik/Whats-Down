package com.petproject.whatsdown.service;

import com.petproject.whatsdown.util.chatting.ChatData;
import com.petproject.whatsdown.util.chatting.ChatMessageData;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Stream;

public interface ChatMangingService {

    Collection<ChatData> getAllChats(UserDetails userDetails);

    Stream<ChatMessageData> getAllMessagesBetween(String firstUsername, String secondUsername);
}
