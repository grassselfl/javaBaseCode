package com.jld.javabasic.type;

public class ReferenceConversion {
    static class Animal {
        private long objectId;
        public String name;

        public Animal(String name, long objectId) {
            this.objectId = objectId;
            this.name = name;
        }

        public Animal() {
        }

        public void isAlive() {
            System.out.println("maybe");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getObjectId() {
            return objectId;
        }
    }

    static class Fish extends Animal {
        public String plumage_color;//羽毛颜色

        public Fish(String name, String plumage_color) {
            this.name = name;
            this.plumage_color = plumage_color;
        }

        @Override
        public void isAlive() {
            System.out.println("alive fish");
        }

        public void swim() {
            System.out.println("fish is swimming");
        }
    }

    static class Bird extends Animal {
        public String scaleColor;//鳞片颜色

        public Bird(String name, String scaleColor, long objectId) {
            super(name, objectId);
            this.scaleColor = scaleColor;
        }

        public void fly() {
            System.out.println("bird is flying");
        }

        @Override
        public void isAlive() {
            System.out.println("alive bird");
        }
    }

    public static void main(String[] args) {
        // 向上转型，隐式类型转换，子类引用转父类引用
        Animal animal;
        Fish fish = new Fish("fish", "red");
        animal = fish;
        animal.isAlive();
        System.out.println(animal.getObjectId());

        //向下转型，强制类型转换，父类引用转子类引用
        //1.父类引用指向父类对象
        Animal animal1 = new Animal("animal", 1);
        //Bird bird1 = (Bird) animal1;//java.lang.ClassCastException: Animal cannot be cast to Bird
        //Casting 'animal1' to 'Bird' will produce 'ClassCastException' for any non-null value

        //2.父类引用指向子类对象，安全
        Animal animal2 = new Bird("bird", "black", 2);
        System.out.println(animal2.getObjectId());
        Bird bird2 = (Bird) animal2;
        bird2.fly();
        bird2.isAlive();

        //Fish fish2 = (Fish) animal2;//Bird cannot be cast to Fish


        //两个问题
        //1.父类引用指向父类对象是一定不安全还是可能不安全

        //2.在子类对象创建时到底父类对象创建了么
    }


}
