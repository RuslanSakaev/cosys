package ru.sakaev.backend.repositories; // Объявление пакета для интерфейса ProductRepository

import org.springframework.data.jpa.repository.JpaRepository; // Импорт интерфейса JpaRepository из Spring Data JPA
import org.springframework.stereotype.Repository; // Импорт аннотации Repository из Spring Framework
import ru.sakaev.backend.model.Product; // Импорт класса Product

@Repository // Аннотация, указывающая, что это класс репозитория
public interface ProductRepository extends JpaRepository<Product, Long> { // Объявление интерфейса ProductRepository, расширяющего JpaRepository

}
