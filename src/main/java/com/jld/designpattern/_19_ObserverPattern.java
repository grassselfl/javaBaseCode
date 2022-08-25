package com.jld.designpattern;

import java.util.ArrayList;
import java.util.List;

public class _19_ObserverPattern {
    //多个对象依赖同一个对象，当这一个对象状态改变时，所有依赖这个对象的对象都会收到通知并且自动更新状态

    //主题(Subject)是被观察的对象，而其所有依赖者(Observer)称为观察者
    public interface Subject {
        void resisterObserver(Observer o);

        void removeObserver(Observer o);

        void notifyObserver();
    }


    public static class WeatherData implements Subject {
        private List<Observer> observers;
        private float temperature;
        private float humidity;
        private float pressure;

        public WeatherData() {
            observers = new ArrayList<>();
        }

        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            notifyObserver();
        }

        @Override
        public void resisterObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            int i = observers.indexOf(o);
            if (i >= 0) {
                observers.remove(i);
            }
        }

        @Override
        public void notifyObserver() {
            for (Observer o : observers) {
                o.update(temperature, humidity, pressure);
            }
        }
    }

    public interface Observer {
        void update(float temp, float humidity, float pressure);
    }

    public static class StatisticsDisplay implements Observer {

        public StatisticsDisplay(Subject weatherData) {
            weatherData.resisterObserver(this);
        }

        @Override
        public void update(float temp, float humidity, float pressure) {
            System.out.println("StatisticsDisplay.update: " + temp + " " + humidity + " " + pressure);
        }
    }

    public static class CurrentConditionsDisplay implements Observer {

        public CurrentConditionsDisplay(Subject weatherData) {
            weatherData.resisterObserver(this);
        }

        @Override
        public void update(float temp, float humidity, float pressure) {
            System.out.println("CurrentConditionsDisplay.update: " + temp + " " + humidity + " " + pressure);
        }
    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(0, 0, 0);
        weatherData.setMeasurements(1, 1, 1);
    }
    //java.util.Observer
}
