package com.petproject.whatsdown.dto;

import com.petproject.whatsdown.util.chatting.ContactData;

import java.util.Collection;

public class ContactsDto {

    private Collection<ContactData> contactEntities;

    public Collection<ContactData> getContacts() {
        return contactEntities;
    }

    public void setContacts(Collection<ContactData> contactEntities) {
        this.contactEntities = contactEntities;
    }

    public ContactsDto(Collection<ContactData> contactEntities) {
        this.contactEntities = contactEntities;
    }

    public ContactsDto() {}


}
