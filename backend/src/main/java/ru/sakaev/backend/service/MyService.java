package ru.sakaev.backend.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void processMessage(Message<String> message) {
        // Обработка входящего сообщения
        String payload = message.getPayload();
        System.out.println("Received message: " + payload);
        // Дополнительная логика обработки сообщения
    }
}