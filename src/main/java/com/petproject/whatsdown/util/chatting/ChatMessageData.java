package com.petproject.whatsdown.util.chatting;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;

public class ChatMessageData {

    private String text;

    private UserData sender;

    private Long chatId;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public UserData getReceiver() {
        return receiver;
    }

    public void setReceiver(UserData receiver) {
        this.receiver = receiver;
    }

    private UserData receiver;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserData getSender() {
        return sender;
    }

    public void setSender(UserData sender) {
        this.sender = sender;
    }

    public ChatMessageData(String text, UserData sender, UserData receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }

    public ChatMessageData(String text, UserDetails sender, UserDetails receiver, Long chatId) {
        this.text = text;
        this.sender = new UserData(sender.getUsername());
        this.receiver = new UserData(receiver.getUsername());
    }

    public ChatMessageData() {
    }

    public ChatMessageData(String text, @NotNull UserDetails userDetails) {
        this.text = text;
        this.sender = new UserData(userDetails.getUsername());
    }
}
