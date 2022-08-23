package com.jld.designpattern;
//抽象工厂其实就是帮助减少系统的工厂数量的，但前提条件就是这些工厂要具备两个及以上的共性。
public class _4_AbstractFactoryPattern {
    //一个工厂创建多类商品
//    抽象工厂模式总结
//
//    优点：
//
//    可以确保同一工厂生成的产品相互匹配。
//    可以避免客户端和具体产品代码的耦合。
//    单一职责原则。 可以将产品生成代码抽取到同一位置， 使得代码易于维护。
//    开闭原则。 向应用程序中引入新产品变体时， 无需修改客户端代码。
//    缺点：
//
//    由于采用该模式需要向应用中引入众多接口和类，代码可能会比之前更加复杂。
    abstract static class DrinkProduct {
        public abstract void showDetails();
    }

    static class Coffee extends DrinkProduct {
        @Override
        public void showDetails() {
            System.out.println("coffee");
        }
    }

    static class Tea extends DrinkProduct {
        @Override
        public void showDetails() {
            System.out.println("tea");
        }
    }

    abstract static class FruitProduct {
        public abstract void showDetails();
    }

    static class Apple extends FruitProduct {
        @Override
        public void showDetails() {
            System.out.println("apple");
        }
    }

    static class Strawberry extends FruitProduct {
        @Override
        public void showDetails() {
            System.out.println("strawberry");
        }
    }


    abstract static class FoodAbstractFactory {
        //在于从两个维度进行了划分，类别和种类
        //简易工厂模式，所有的种类的商品都在同一个工厂中，不划分
        //工厂方法模式，所有的种类的商品各自具有一个工厂生产，一维划分
        //抽象工厂模式，所有种类的商品被按品牌划分，一个工厂生产一个品牌的商品，二维划分
        public abstract DrinkProduct factoryDrinkMethod();

        public abstract FruitProduct factoryFruitMethod();
    }

    static class MealSetFactory1 extends FoodAbstractFactory {
        @Override
        public DrinkProduct factoryDrinkMethod() {
            return new Coffee();
        }

        @Override
        public FruitProduct factoryFruitMethod() {
            return new Apple();
        }
    }

    static class MealSetFactory2 extends FoodAbstractFactory {
        @Override
        public DrinkProduct factoryDrinkMethod() {
            return new Tea();
        }

        @Override
        public FruitProduct factoryFruitMethod() {
            return new Strawberry();
        }
    }

    public static void main(String[] args) {
        FoodAbstractFactory foodAbstractFactory = new MealSetFactory1();
        DrinkProduct coffee = foodAbstractFactory.factoryDrinkMethod();
        FruitProduct apple = foodAbstractFactory.factoryFruitMethod();
    }
}
