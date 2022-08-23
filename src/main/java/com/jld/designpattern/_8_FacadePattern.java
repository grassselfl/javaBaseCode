package com.jld.designpattern;
//提供了一个统一的接口，用来访问子系统中的一群接口，从而让子系统更容易使用。
public class _8_FacadePattern {
    static class Person{
        public void openRefrigerator(){
            System.out.println("open the refrigerator");
        }
        public void putElephantIntoRefrigerator(){
            System.out.println("put the elephant into the refrigerator");
        }
        public void closeRefrigerator(){
            System.out.println("close the refrigerator");
        }


    }


    static class PersonFacade{

        Person person = new Person();

        public void putElephantIntoRefrigerator(){
            person.openRefrigerator();
            person.putElephantIntoRefrigerator();
            person.closeRefrigerator();
        }
    }

    public static void main(String[] args) {
        PersonFacade personFacade = new PersonFacade();
        personFacade.putElephantIntoRefrigerator();
    }
}
