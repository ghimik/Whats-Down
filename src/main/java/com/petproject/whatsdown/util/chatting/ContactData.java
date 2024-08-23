package com.petproject.whatsdown.util.chatting;

import com.petproject.whatsdown.model.ContactEntity;
import org.springframework.security.core.userdetails.UserDetails;

public class ContactData {

    private String with;

    public String getWith() {
        return with;
    }

    public void setWith(String with) {
        this.with = with;
    }

    public ContactData() {}

    public ContactData(String with) {this.with = with;}

    public ContactData(UserDetails myUserDetails, ContactEntity contact) {
        if (contact.getFirst().getUsername().equals(myUserDetails.getUsername()))
            this.with = contact.getSecond().getUsername();
        else
            this.with = contact.getFirst().getUsername();
    }

}
