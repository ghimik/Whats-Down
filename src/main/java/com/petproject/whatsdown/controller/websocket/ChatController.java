package com.petproject.whatsdown.controller.websocket;

import com.petproject.whatsdown.service.ChatMangingService;
import com.petproject.whatsdown.util.chatting.ChatMessageData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired private ChatMangingService chatMangingService;

    @SendTo("/topic/messages/{chatId}") // на какой брокер отправляем ответ
    @MessageMapping("/sendMessage/{chatId}") // с какого эндпоинта получаем сообщение (/ws/app/sendMessage,
    // так как указан префикс апп и сам клиент настроен на вс)
    public ChatMessageData send(@DestinationVariable Long chatId, ChatMessageData message) {
        System.out.println(chatId);
        System.out.println(message.getText());

        chatMangingService.saveMessage(message,
                message.getSender().getUsername(),
                message.getReceiver().getUsername()
        );
        return message;
    }
}
