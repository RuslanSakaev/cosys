package ru.sakaev.backend.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.sakaev.backend.model.User;
import ru.sakaev.backend.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        // Создаем мок пользователя
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        // Задаем поведение мока userRepository
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(passwordEncoder.encode(any(CharSequence.class))).thenReturn("encodedPassword");

        // Вызываем метод сервиса
        User createdUser = userService.createUser(user);

        // Проверяем, что пользователь создан
        assertNotNull(createdUser);
        assertEquals(user.getUsername(), createdUser.getUsername());
        assertEquals("encodedPassword", createdUser.getPassword());
    }

    @Test
    void testGetAllUsers() {
        // Создаем список моков пользователей
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());

        // Задаем поведение мока userRepository
        when(userRepository.findAll()).thenReturn(userList);

        // Вызываем метод сервиса
        List<User> retrievedUsers = userService.getAllUsers();

        // Проверяем, что список пользователей получен
        assertEquals(userList.size(), retrievedUsers.size());
    }
}
