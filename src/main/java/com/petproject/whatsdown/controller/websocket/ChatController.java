package com.petproject.whatsdown.controller.websocket;

import com.petproject.whatsdown.service.ChatMangingService;
import com.petproject.whatsdown.util.chatting.ChatMessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired private ChatMangingService chatMangingService;

    @SendTo("/topic/messages") // на какой брокер отправляем ответ
    @MessageMapping("/sendMessage") // с какого эндпоинта получаем сообщение (/ws/app/sendMessage,
    // так как указан префикс апп и сам клиент настроен на вс)
    public ChatMessageData send(ChatMessageData message) {
        chatMangingService.saveMessage(message);
        return message;
    }
}
