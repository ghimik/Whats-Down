package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.Contact;
import com.petproject.whatsdown.model.ContactEntity;

import java.util.Collection;

public interface ContactService {

    public ContactEntity addContact(String initiatorUsername, String receiverUsername);

    public ContactEntity removeContact(String initiatorUsername, String receiverUsername);

    public Collection<Contact> getContacts(String username);

}
