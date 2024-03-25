package ru.sakaev.webclient.config;

import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import ru.sakaev.webclient.entity.PaymentClientApi;
import ru.sakaev.webclient.entity.StorageClientApi;
import ru.sakaev.webclient.seriveces.ShopService;

/**
 * Класс конфигурации тестирования.
 */
@TestConfiguration
@RequiredArgsConstructor
public class TestConfig {

    @Bean
    @Primary
    public PaymentClientApi paymentClientApi(){
        return Mockito.mock(PaymentClientApi.class);
    }

    @Bean
    @Primary
    public StorageClientApi storageClientApi(){
        return Mockito.mock(StorageClientApi.class);
    }

    @Bean
    @Primary
    public ShopService shopService(){
        return new ShopService(paymentClientApi(), storageClientApi(), "2");
    }
}
