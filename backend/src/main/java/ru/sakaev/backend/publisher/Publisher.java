package ru.sakaev.backend.publisher;

import org.springframework.stereotype.Component;
import ru.sakaev.backend.observer.Observer;

@Component
public interface Publisher {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}