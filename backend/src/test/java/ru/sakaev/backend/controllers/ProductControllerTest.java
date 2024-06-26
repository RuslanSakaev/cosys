package ru.sakaev.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.sakaev.backend.configuration.FileWritingIntegration;
import ru.sakaev.backend.model.Product;
import ru.sakaev.backend.model.ProductTest;
import ru.sakaev.backend.service.ProductService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest {

    private MockMvc mockMvc;

    ProductService productService = mock(ProductService.class);


    @Mock
    private MeterRegistry meterRegistry;

    @Mock
    private FileWritingIntegration.ProductGateway productGateway;

    @BeforeEach
    public void setup() {
        ProductController productController = new ProductController(productService, meterRegistry, productGateway);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetAllProducts() throws Exception {
        ProductTest product1 = new ProductTest();
        product1.setId(1L);
        product1.setName("Product 1");
        product1.setDescription("Description for product 1");
        product1.setPrice(10.0);
        product1.setQuantity(5);

        ProductTest product2 = new ProductTest();
        product2.setId(2L);
        product2.setName("Product 2");
        product2.setDescription("Description for product 2");
        product2.setPrice(20.0);
        product2.setQuantity(10);


        mockMvc.perform(get("/api/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

    }

    @Test
    public void testCreateProduct() throws Exception {
        Product product = new Product();
        product.setName("New Product");
        product.setDescription("Description for new product");
        product.setPrice(30.0);
        product.setQuantity(15);

        // Настройка поведения мок-объекта productService для метода createProduct()
        when(productService.createProduct(any())).thenReturn(product);

        mockMvc.perform(post("/api/products/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(product)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("New Product"))
                .andExpect(jsonPath("$.description").value("Description for new product"))
                .andExpect(jsonPath("$.price").value(30.0))
                .andExpect(jsonPath("$.quantity").value(15));
    }


    @Test
    public void testUpdateProduct() throws Exception {
        Long productId = 1L;
        Product existingProduct = new Product();
        existingProduct.setId(productId);
        existingProduct.setName("Existing Product");
        existingProduct.setDescription("Description for existing product");
        existingProduct.setPrice(25.0);
        existingProduct.setQuantity(20);

        Product updatedProduct = new Product();
        updatedProduct.setId(productId);
        updatedProduct.setName("Updated Product");
        updatedProduct.setDescription("Updated description");
        updatedProduct.setPrice(30.0);
        updatedProduct.setQuantity(25);

        // Настройка поведения мок-объекта productService для метода getProductById()
        when(productService.getProductById(productId)).thenReturn(existingProduct);

        // Настройка поведения мок-объекта productService для метода updateProduct()
        int newQuantity = 0;
        when(productService.updateProduct(eq(productId), any(Product.class), newQuantity)).thenReturn(updatedProduct);

        mockMvc.perform(put("/api/products/{id}", productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(updatedProduct)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Product"))
                .andExpect(jsonPath("$.description").value("Updated description"))
                .andExpect(jsonPath("$.price").value(30.0))
                .andExpect(jsonPath("$.quantity").value(25));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        Long productId = 1L;

        mockMvc.perform(delete("/api/products/{id}", productId))
                .andExpect(status().isNoContent());

        verify(productService, times(1)).deleteProduct(productId);
    }

    // Метод для сериализации объекта в JSON строку
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
