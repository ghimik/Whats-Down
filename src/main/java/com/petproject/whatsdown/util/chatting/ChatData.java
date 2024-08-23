package com.petproject.whatsdown.util.chatting;

import com.petproject.whatsdown.model.ContactEntity;
import org.springframework.security.core.userdetails.UserDetails;

public class ChatData {

    private Long id;

    private String friendName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public ChatData() {}

    public ChatData(String friendName, Long id) {this.friendName = friendName; this.id = id;}

    public ChatData(UserDetails myUserDetails, ContactEntity contact) {
        if (contact.getFirst().getUsername().equals(myUserDetails.getUsername()))
            this.friendName = contact.getSecond().getUsername();
        else
            this.friendName = contact.getFirst().getUsername();

        this.id = contact.getChatRoom().getId();
    }
}
