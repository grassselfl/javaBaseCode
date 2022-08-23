package com.jld.designpattern;

public class _6_PrototypePattern {
    //模式分析
//原型模式，在java中使用浅克隆时，当原型对象被复制时，只复制它本身和其中包含的值类型的成员变量，而引用类型的成员变量并没有复制；而使用深克隆时，除了对象本身被复制外，对象所包含的所有成员变量也将被复制。
//            3.1 优点
//原型模式简化了创建对象的过程，通过一个已有的实例进行复制提高了创建实例的效率，具有较好的可扩展性。
//            3.2 缺点
//部分时候实现克隆可能较为麻烦。
//            3.3 适用场景
//原型模式适合于当一个类初始化需要消耗很多资源时，有很多相似对象时，可以设计一个原型，通过对成员变量的些微修改来实现；需要时可以用深克隆的方式保存对象的状态，比如实现撤销操作等。
    public static class Prototype implements Cloneable {

        private String filed;

        public Prototype(String filed) {
            this.filed = filed;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Object o;
            try {
                o = super.clone();
            } catch (Exception e) {
                o = null;
            }
            return o;
        }

        @Override
        public String toString() {
            return filed;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype("abc");
        Prototype clone = (Prototype) prototype.clone();
        System.out.println(clone.toString());
        //java clone是浅拷贝
        //浅拷贝只拷贝变量值
        //深拷贝应该注意两点，1）拷贝所指内存中的值，2）重构引用关系
    }
}
