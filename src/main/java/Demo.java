public class Demo {

    public static void func6() {
        int i = 1 / 0;
    }


    public static void func5() {
        func6();
    }


    public static void func4() {
        func5();
    }

    public static void func3() {
        try {
            func4();
        } catch (Exception e) {
            throw new RuntimeException("func3", e);
        }
    }

    public static void func2() {
        func3();
    }

    public static void func1() {
        func2();
    }

    public static void main(String[] args) {
        func1();
    }
}

// Exception in thread "main" java.lang.RuntimeException: func3
//     at Demo.func3(Demo.java:21)
//     at Demo.func2(Demo.java:26)
//     at Demo.func1(Demo.java:30)
//     at Demo.main(Demo.java:34)
//     Caused by: java.lang.ArithmeticException: / by zero
//     at Demo.func6(Demo.java:4)
//     at Demo.func5(Demo.java:9)
//     at Demo.func4(Demo.java:14)
//     at Demo.func3(Demo.java:19)
//     ... 3 more