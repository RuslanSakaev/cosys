package ru.sakaev.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;

import java.io.File;

@Configuration
public class FileWritingIntegration {

    @Bean
    public MessageChannel requestChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "requestChannel")
    public FileWritingMessageHandler fileWriter(ProductGateway productGateway) {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("/home/lab/file"));
        handler.setExpectReply(false);
        handler.setAppendNewLine(true);
        handler.setFileNameGenerator(message -> "request_" + System.currentTimeMillis() + ".txt");
        return handler;
    }

    @MessagingGateway(defaultRequestChannel = "requestChannel")
    public interface ProductGateway {
        void writeToFile(@Header("http_requestMethod") String method, @Header("http_requestUrl") String url, String payload);
    }
}
