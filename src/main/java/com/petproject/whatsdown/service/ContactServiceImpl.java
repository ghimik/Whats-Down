package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.ContactEntity;
import com.petproject.whatsdown.repository.ContactRepository;
import com.petproject.whatsdown.repository.UserRepository;
import com.petproject.whatsdown.util.chatting.ContactData;
import com.petproject.whatsdown.util.user.UserPair;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired private UserDataManagementService userDataManagementService;

    @Autowired private ContactRepository contactRepository;

    @Autowired private UserRepository userRepository;

    @Override
    public ContactEntity addContact(String initiatorUsername, String receiverUsername) {
        UserPair userPair = getUserPair(initiatorUsername, receiverUsername);

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setFirst(userPair.getFirst());
        contactEntity.setSecond(userPair.getSecond());

        contactRepository.saveAndFlush(contactEntity);
        return contactEntity;
    }

    @Override
    public ContactEntity removeContact(String initiatorUsername, String receiverUsername) {
        UserPair userPair = getUserPair(initiatorUsername, receiverUsername);

        ContactEntity contactEntity = contactRepository.findByFirstAndSecondOrSecondAndFirst(
                userPair.getFirst().getId(),
                userPair.getSecond().getId()
        );

        contactRepository.delete(contactEntity);
        contactRepository.flush();
        return contactEntity;
    }

    @Override
    public Collection<ContactData> getContacts(String username) {
        return contactRepository
                        .findAll(
                                userRepository.findByUsername(username).getId()
                        )
                .stream()
                .map(contactEntity ->
                {
                    try {
                        return new ContactData(userDataManagementService.getCurrentUser(), contactEntity);
                    } catch (AuthenticationException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }

    private UserPair getUserPair(String initiatorUsername, String receiverUsername) {
        return  UserPair.builder()
                .fromRepository(userRepository)
                .withFirstUsername(initiatorUsername)
                .withSecondUsername(receiverUsername)
                .build();
    }
}
