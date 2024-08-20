package com.petproject.whatsdown.repository;

import com.petproject.whatsdown.model.ChatRoom;
import com.petproject.whatsdown.model.Contact;
import com.petproject.whatsdown.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query( "SELECT c " +
            "FROM Contact c " +
            "WHERE (c.first = :first AND c.second = :second) " +
            "       OR" +
            "      (c.first = :second AND c.second = :first)")
    Contact findByFirstAndSecondOrSecondAndFirst(@Param("first") User first,
                                                 @Param("second") User second);

    @Query( "SELECT c " +
            "FROM Contact c " +
            "WHERE c.first = :user OR c.second = :user")
    Collection<Contact> findAll(@Param("user") User user);


}
