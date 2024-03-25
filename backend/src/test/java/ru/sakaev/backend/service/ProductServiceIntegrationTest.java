package ru.sakaev.backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Test
    public void contextLoads() {
        // Проверяем, что ProductService был успешно загружен в контекст Spring
        assertThat(productService).isNotNull();
    }
}

