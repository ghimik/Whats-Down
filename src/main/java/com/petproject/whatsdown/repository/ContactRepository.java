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

    @Query( value = "SELECT * " +
            "FROM Contact c " +
            "WHERE (c.first = :first AND c.second = :second) " +
            "       OR" +
            "      (c.first = :second AND c.second = :first)", nativeQuery = true)
    ContactEntity findByFirstAndSecondOrSecondAndFirst(@Param("first") Long first,
                                                       @Param("second") Long second);

    @Query( value = "SELECT * " +
            "FROM Contact " +
            "WHERE first = :userId OR second = :userId", nativeQuery = true)
    Collection<ContactEntity> findAll(@Param("userId") Long userId);



}
