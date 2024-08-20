package com.petproject.whatsdown.repository;

import com.petproject.whatsdown.model.ChatMessageEntity;
import com.petproject.whatsdown.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {

    Stream<ChatMessageEntity> findAllByChatRoom(ChatRoom chatRoom);
}
