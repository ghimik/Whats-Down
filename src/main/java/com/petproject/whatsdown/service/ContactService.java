package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.ContactEntity;
import com.petproject.whatsdown.util.chatting.ContactData;

import java.util.Collection;

public interface ContactService {

    public ContactEntity addContact(String initiatorUsername, String receiverUsername);

    public ContactEntity removeContact(String initiatorUsername, String receiverUsername);

    public Collection<ContactData> getContacts(String username);

}
