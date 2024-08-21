package com.petproject.whatsdown.repository;

import com.petproject.whatsdown.model.ContactEntity;
import com.petproject.whatsdown.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    @Query( "SELECT c " +
            "FROM Contact c " +
            "WHERE (c.first = :first AND c.second = :second) " +
            "       OR" +
            "      (c.first = :second AND c.second = :first)")
    ContactEntity findByFirstAndSecondOrSecondAndFirst(@Param("first") UserEntity first,
                                                       @Param("second") UserEntity second);

    @Query( "SELECT c " +
            "FROM Contact c " +
            "WHERE c.first = :user OR c.second = :user")
    Collection<ContactEntity> findAll(@Param("user") UserEntity userEntity);


}
