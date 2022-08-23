package com.jld.designpattern;

public class _9_AdapterPattern {
    public interface Person {
        void say(String words);
    }
    public interface Dog {
        void wang();
    }
    public static class ErGou implements Person {
        @Override
        public void say(String words) {
            System.out.println(words);
        }
    }
    public static class FakerDog implements Dog {
        private Person person;

        public FakerDog(Person person) {
            this.person = person;
        }

        @Override
        public void wang() {
            person.say("汪汪汪");
        }
    }
    public static void main(String[] args) {
        Person erGou = new ErGou();
        Dog dog = new FakerDog(erGou);
        dog.wang();
    }


}
