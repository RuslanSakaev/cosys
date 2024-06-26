package ru.sakaev.backend.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Класс для наблюдаемого объекта
public class ProductQuantityPublisher {
    private final List<Observer> observers = new ArrayList<>();
    private int quantity;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(quantity);
        }
    }
}
