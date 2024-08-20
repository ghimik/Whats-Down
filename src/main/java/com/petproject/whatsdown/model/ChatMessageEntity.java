package com.petproject.whatsdown.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chatmessage")
public class ChatMessageEntity implements ChatMessage {

    @Id
    @Column(name = "\"id\"")
    @SequenceGenerator(name = "chatmessage_id_seq", sequenceName = "chatmessage_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chatmessage_id_seq")
    private Long id;

    @Column(name = "text")
    private String text;

    @JoinColumn(name = "chatroom")
    @ManyToOne(targetEntity = ChatRoom.class)
    private ChatRoom chatRoom;

    @JoinColumn(name = "sender")
    @ManyToOne(targetEntity = User.class)
    private User sender;

    @JoinColumn(name = "receiver")
    @ManyToOne(targetEntity = User.class)
    private User receiver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
