package com.jld.designpattern;

import java.util.HashMap;

public class _14_FlyweightPattern {
    //享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式。
    //享元模式尝试重用现有的同类对象，如果未找到匹配的对象，则创建新对象。
    //意图：运用共享技术有效地支持大量细粒度的对象。

    public interface Flyweight {
        void doOperation(String extrinsicState);
    }

    public static class ConcreteFlyweight implements Flyweight {

        private String intrinsicState;

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }

        @Override
        public void doOperation(String extrinsicState) {
            System.out.println("Object address: " + System.identityHashCode(this));
            System.out.println("IntrinsicState: " + intrinsicState);
            System.out.println("ExtrinsicState: " + extrinsicState);
        }
    }

    public static class FlyweightFactory {

        private HashMap<String, Flyweight> flyweights = new HashMap<>();

        Flyweight getFlyweight(String intrinsicState) {
            if (!flyweights.containsKey(intrinsicState)) {
                Flyweight flyweight = new ConcreteFlyweight(intrinsicState);
                flyweights.put(intrinsicState, flyweight);
            }
            return flyweights.get(intrinsicState);
        }
    }

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("aa");
        Flyweight flyweight2 = factory.getFlyweight("aa");
        flyweight1.doOperation("x");
        flyweight2.doOperation("y");
//        Integer.valueOf(1);
    }

    //Java 利用缓存来加速大量小对象的访问时间。
    // java.lang.Integer#valueOf(int)
    // java.lang.Boolean#valueOf(boolean)
    // java.lang.Byte#valueOf(byte)
    // java.lang.Character#valueOf(char)

}
