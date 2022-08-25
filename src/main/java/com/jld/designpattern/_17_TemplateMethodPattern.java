package com.jld.designpattern;

public class _17_TemplateMethodPattern {

    public static abstract class CaffeineBeverage {

        final void prepareRecipe() {
            boilWater();
            brew();
            pourInCup();
            addCondiments();
        }

        abstract void brew();

        abstract void addCondiments();

        void boilWater() {
            System.out.println("boilWater");
        }

        void pourInCup() {
            System.out.println("pourInCup");
        }
    }


    public static class Coffee extends CaffeineBeverage {
        @Override
        void brew() {
            System.out.println("Coffee.brew");
        }

        @Override
        void addCondiments() {
            System.out.println("Coffee.addCondiments");
        }
    }


    public static class Tea extends CaffeineBeverage {
        @Override
        void brew() {
            System.out.println("Tea.brew");
        }

        @Override
        void addCondiments() {
            System.out.println("Tea.addCondiments");
        }
    }


    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new Coffee();
        caffeineBeverage.prepareRecipe();
        System.out.println("-----------");
        caffeineBeverage = new Tea();
        caffeineBeverage.prepareRecipe();
    }

    //java.util.Collections#sort()

}
