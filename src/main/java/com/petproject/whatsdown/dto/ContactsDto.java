package com.petproject.whatsdown.dto;

import com.petproject.whatsdown.model.Contact;
import com.petproject.whatsdown.model.ContactEntity;

import java.util.Collection;

public class ContactsDto {

    private Collection<Contact> contactEntities;

    public Collection<Contact> getContacts() {
        return contactEntities;
    }

    public void setContacts(Collection<Contact> contactEntities) {
        this.contactEntities = contactEntities;
    }

    public ContactsDto(Collection<Contact> contactEntities) {
        this.contactEntities = contactEntities;
    }

    public ContactsDto() {}


}
