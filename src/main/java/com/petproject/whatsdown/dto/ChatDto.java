package com.petproject.whatsdown.dto;

import com.petproject.whatsdown.util.chatting.ChatMessageData;

import java.util.Collection;

public class ChatDto {
    private Collection<ChatMessageData> messages;

    public Collection<ChatMessageData> getMessages() {
        return messages;
    }

    public void setMessages(Collection<ChatMessageData> messages) {
        this.messages = messages;
    }

    public ChatDto(Collection<ChatMessageData> messages) {
        this.messages = messages;
    }

    public ChatDto() {}
}
