package com.jld.javabasic;

//shallow clone、deep clone
class Name implements Cloneable {
    private String name;//字符串可以指向一个

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    private Name name;
    private int age;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(Name name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return this.age == person.age && this.name.getName().equals(person.name.getName());
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public Person shallowClone() throws CloneNotSupportedException {
        return clone();
    }

    public Person deepClone() throws CloneNotSupportedException {
        Person person = clone();
        person.name = (Name) person.name.clone();
        return person;
    }


}

public class ObjectClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person0 = new Person(new Name("li"), 12);
        Person person1 = new Person(new Name("li"), 12);
        Person person2 = person1.shallowClone();
        Person person3 = person1.deepClone();
        System.out.println(person0.equals(person1));
        System.out.println(person1.equals(person2));
        System.out.println(person2.equals(person3));
        System.out.println(person1.getName() == person2.getName());
        System.out.println(person2.getName() == person3.getName());
    }
}
