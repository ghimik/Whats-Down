package com.petproject.whatsdown.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @Column(name = "\"id\"")
    @SequenceGenerator(name = "contacts_id_seq", sequenceName = "contacts_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_id_seq")
    private Long id;

    @JoinColumn(name = "first")
    @ManyToOne(targetEntity = User.class)
    private User first;

    @JoinColumn(name = "second")
    @ManyToOne(targetEntity = User.class)
    private User second;

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    @JoinColumn(name = "chatid")
    @ManyToOne(targetEntity = ChatRoom.class)
    private ChatRoom chatRoom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFirst() {
        return first;
    }

    public void setFirst(User first) {
        this.first = first;
    }

    public User getSecond() {
        return second;
    }

    public void setSecond(User second) {
        this.second = second;
    }
}
