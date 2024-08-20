package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.Contact;

import java.util.Collection;

public interface ContactService {

    public Contact addContact(String initiatorUsername, String receiverUsername);

    public Contact removeContact(String initiatorUsername, String receiverUsername);

    public Collection<Contact> getContacts(String username);

}
