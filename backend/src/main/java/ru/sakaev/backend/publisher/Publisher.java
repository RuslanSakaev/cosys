package ru.sakaev.backend.publisher;

import ru.sakaev.backend.observer.Observer;

public interface Publisher {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}