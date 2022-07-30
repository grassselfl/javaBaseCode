package com.jld.javabasic.type;

public class ReferenceConversionQuestion2 {
    static class Animal {
        private long objectId;
        public String name;

        public Animal(String name, long objectId) {
            this.objectId = objectId;
            this.name = name;
        }

        public long getObjectId() {
            return objectId;
        }
    }

    static class Fish extends Animal {
        public String plumage_color;

        public Fish(String name, String plumage_color, long objectId) {
            super(name, objectId);
            this.plumage_color = plumage_color;
        }
    }

    public static void main(String[] args) {
        // 向上转型，隐式类型转换，子类引用转父类引用
        Animal animal = new Fish("fish", "red", 1);
        System.out.println(animal.getObjectId());


        //2.在子类对象创建时到底父类对象创建了么
        //答曰没有创建，但是子类持有父类所有成员，只是受权限访问能控制，只能访问部分，即只能继承部分
    }
}


