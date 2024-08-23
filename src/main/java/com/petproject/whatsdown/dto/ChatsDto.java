package com.petproject.whatsdown.dto;

import com.petproject.whatsdown.util.chatting.ChatData;

import java.util.Collection;

public class ChatsDto {

    private Collection<ChatData> contacts;

    public Collection<ChatData> getContacts() {
        return contacts;
    }

    public void setContacts(Collection<ChatData> contactEntities) {
        this.contacts = contactEntities;
    }

    public ChatsDto(Collection<ChatData> contacts) {
        this.contacts = contacts;
    }

    public ChatsDto() {}
}
