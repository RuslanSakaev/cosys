package ru.sakaev.backend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyService {

    public void processMessage(Message<String> message) {
        // Обработка входящего сообщения
        String payload = message.getPayload();
        log.info("Received message: {}", payload);

        // Дополнительная логика обработки сообщения
        if (payload.contains("important")) {
            // Если сообщение содержит ключевое слово "important", выполнить какие-то действия
            log.info("This message is important!");

            // Например, отправить уведомление администратору
            sendAdminNotification("Important message received: " + payload);
        } else {
            // Иначе, выполнить другие действия
            log.info("This message is not important.");
        }
    }

    private void sendAdminNotification(String message) {
        // Логика для отправки уведомления администратору
        log.info("Sending admin notification: {}", message);
    }
}