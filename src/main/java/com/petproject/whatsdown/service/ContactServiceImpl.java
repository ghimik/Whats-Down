package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.Contact;
import com.petproject.whatsdown.repository.ContactRepository;
import com.petproject.whatsdown.repository.UserRepository;
import com.petproject.whatsdown.util.user.UserPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired private ContactRepository contactRepository;

    @Autowired private UserRepository userRepository;

    @Override
    public Contact addContact(String initiatorUsername, String receiverUsername) {
        UserPair userPair = getUserPair(initiatorUsername, receiverUsername);

        Contact contact = new Contact();
        contact.setFirst(userPair.getFirst());
        contact.setSecond(userPair.getSecond());

        contactRepository.saveAndFlush(contact);
        return contact;
    }

    @Override
    public Contact removeContact(String initiatorUsername, String receiverUsername) {
        UserPair userPair = getUserPair(initiatorUsername, receiverUsername);

        Contact contact = contactRepository.findByFirstAndSecondOrSecondAndFirst(
                userPair.getFirst(),
                userPair.getSecond()
        );

        contactRepository.delete(contact);
        contactRepository.flush();
        return contact;
    }

    @Override
    public Collection<Contact> getContacts(String username) {
        return contactRepository
                        .findAll(
                                userRepository.findByUsername(username)
                        );
    }

    private UserPair getUserPair(String initiatorUsername, String receiverUsername) {
        return  UserPair.builder()
                .fromRepository(userRepository)
                .withFirstUsername(initiatorUsername)
                .withSecondUsername(receiverUsername)
                .build();
    }
}
