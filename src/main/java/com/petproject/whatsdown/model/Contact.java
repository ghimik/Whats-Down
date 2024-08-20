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
    private User firstUser;

    @JoinColumn(name = "second")
    @ManyToOne(targetEntity = User.class)
    private User secondUser;
}
