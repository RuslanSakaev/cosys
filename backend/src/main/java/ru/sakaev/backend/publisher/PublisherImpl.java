package ru.sakaev.backend.publisher;

import ru.sakaev.backend.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class PublisherImpl implements Publisher {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
