package com.petproject.whatsdown.repos;

import com.petproject.whatsdown.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
