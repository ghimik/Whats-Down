package com.petproject.whatsdown.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chatroom")
public class ChatRoom {

    @Id
    @Column(name = "\"id\"")
    @SequenceGenerator(name = "chatroom_id_seq", sequenceName = "chatroom_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chatroom_id_seq")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
