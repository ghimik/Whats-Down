package com.petproject.whatsdown.dto;

import com.petproject.whatsdown.model.ChatMessage;

import java.util.Collection;

public class ChatDto {
    private Collection<ChatMessage> messages;

    public Collection<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(Collection<ChatMessage> messages) {
        this.messages = messages;
    }

    public ChatDto(Collection<ChatMessage> messages) {
        this.messages = messages;
    }

    public ChatDto() {}
}
