package com.petproject.whatsdown.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class ContactEntity {

    @Id
    @Column(name = "\"id\"")
    @SequenceGenerator(name = "contacts_id_seq", sequenceName = "contacts_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_id_seq")
    private Long id;

    @JoinColumn(name = "first")
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity first;

    @JoinColumn(name = "second")
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity second;

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    @JoinColumn(name = "chatid")
    @ManyToOne(targetEntity = ChatRoom.class)
    @Nullable
    private ChatRoom chatRoom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getFirst() {
        return first;
    }

    public void setFirst(UserEntity first) {
        this.first = first;
    }

    public UserEntity getSecond() {
        return second;
    }

    public void setSecond(UserEntity second) {
        this.second = second;
    }
}
