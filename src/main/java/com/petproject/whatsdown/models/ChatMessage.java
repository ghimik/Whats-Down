package com.petproject.whatsdown.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chatmessage")
public class ChatMessage {

    @Id
    @Column(name = "id")
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
}
