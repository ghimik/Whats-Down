package com.petproject.whatsdown.repository;

import com.petproject.whatsdown.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
