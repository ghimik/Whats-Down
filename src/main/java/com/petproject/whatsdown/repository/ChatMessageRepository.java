package com.petproject.whatsdown.repository;

import com.petproject.whatsdown.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}