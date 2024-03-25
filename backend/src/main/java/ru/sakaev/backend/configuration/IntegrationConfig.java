package ru.sakaev.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import ru.sakaev.backend.service.MyService;

@Configuration
public class IntegrationConfig {
    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "inputChannel")
    public MyService myService() {
        return new MyService();
    }
}