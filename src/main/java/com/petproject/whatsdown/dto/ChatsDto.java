package com.petproject.whatsdown.dto;

import com.petproject.whatsdown.model.Contact;

import java.util.Collection;

public class ChatsDto {

    private Collection<Contact> contacts;

    public Collection<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Collection<Contact> contactEntities) {
        this.contacts = contactEntities;
    }

    public ChatsDto(Collection<Contact> contacts) {
        this.contacts = contacts;
    }

    public ChatsDto() {}
}
