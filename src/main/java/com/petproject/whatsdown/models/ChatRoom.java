package com.petproject.whatsdown.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chatroom")
public class ChatRoom {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "chatroom_id_seq", sequenceName = "chatroom_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chatroom_id_seq")
    private Long id;

    @JoinColumn(name = "fistuser")
    @ManyToOne(targetEntity = User.class)
    private User firstUser;

    @JoinColumn(name = "seconduser")
    @ManyToOne(targetEntity = User.class)
    private User secondUser;
}
