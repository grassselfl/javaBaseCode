package com.jld.designpattern;

public class _3_FactoryMethodPattern {
    //抽象产品，abstract product
    //具体产品，concrete product
    //抽象工厂，abstract factory
    //具体工厂，concrete factory
    //通过使用具体工厂从而创建具体产品
    //工厂创建一类多种商品
    abstract static class DrinkProduct{
        public abstract void showDetails();
    }
    static class Coffee extends DrinkProduct{
        @Override
        public void showDetails() {
            System.out.println("coffee");
        }
    }
    static class Tea extends DrinkProduct{
        @Override
        public void showDetails() {
            System.out.println("tea");
        }
    }


    abstract static class DrinkFactory{
        public abstract DrinkProduct factoryMethod();
    }
    static class CoffeeFactory extends DrinkFactory{

        @Override
        public DrinkProduct factoryMethod() {
            return new Coffee();
        }
    }
    static class TeaFactory extends DrinkFactory{

        @Override
        public DrinkProduct factoryMethod() {
            return new Tea();
        }
    }

    public static void main(String[] args) {
        DrinkProduct tea = new TeaFactory().factoryMethod();
        tea.showDetails();
    }
}
