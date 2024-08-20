package com.petproject.whatsdown.dto;

import com.petproject.whatsdown.model.Contact;

import java.util.Collection;

public class ContactsDto {

    private Collection<Contact> contacts;

    public Collection<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Collection<Contact> contacts) {
        this.contacts = contacts;
    }

    public ContactsDto(Collection<Contact> contacts) {
        this.contacts = contacts;
    }

    public ContactsDto() {}


}
