package com.petproject.whatsdown.repos;

import com.petproject.whatsdown.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
