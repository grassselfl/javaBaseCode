package com.jld.javabasic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理商、经销商、分销商、厂家
 */
public class SP {

    interface Business {
        void produce();

        void sale();
    }

    static class BusinessSelf implements Business {

        @Override
        public void produce() {
            System.out.println("生产商品");
        }

        @Override
        public void sale() {
            System.out.println("售卖商品");
        }
    }

    static class BusinessProxy implements Business {

        private final Business business;

        public BusinessProxy() {
            this.business = new BusinessSelf();
        }

        @Override
        public void produce() {
            System.out.println("代理商不生产商品，联系厂家生产");
        }

        @Override
        public void sale() {
            System.out.print("代理商：");
            business.sale();
        }
    }

    static class BusinessDProxy implements Business{
        private final Business business;
        private final Business proxyInstance;

        public BusinessDProxy() {//代理模式就是为了隐匿被代理类，这里不是传入被代理对象，而是直接通过某种方式获取，这里与装饰者模式和适配器模式不一样
            business = new BusinessSelf();
            proxyInstance = (Business)Proxy.newProxyInstance(Business.class.getClassLoader(), new Class[]{Business.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("sale")) {
                        System.out.print("代理商：");
                        return method.invoke(proxy, args);
                    }
                    return method.invoke(proxy, args);
                }
            });
        }
//如果你不传原有的bean，直接用method.invoke(proxy, args)的话，那么就会陷入一个死循环。
        @Override
        public void produce() {//似乎写不写都行
            proxyInstance.produce();
        }

        @Override
        public void sale() {
            proxyInstance.sale();
        }
    }



    static class BusinessInvocationHandler implements InvocationHandler {
        private final Business business;

        public BusinessInvocationHandler() {//代理模式就是为了隐匿被代理类，这里不是传入被代理对象，而是直接通过某种方式获取，这里与装饰者模式和适配器模式不一样
            this.business = new BusinessSelf();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("sale")) {
                System.out.print("代理商：");
                return method.invoke(business, args);
            }
            return method.invoke(business, args);
        }
    }


    public static void main(String[] args) {

        Business proxyInstance = (Business) Proxy.newProxyInstance(Business.class.getClassLoader(), new Class[]{Business.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理商");
                return method.invoke(proxy, args);
            }
        });
        proxyInstance.sale();
    }
    //不应该创建对象再传进来吧
}
//《反射机制、动态代理》

//jdk动态代理只能基于接口，代理生成的对象只能赋值给接口变量，而Cglib就不存在这个问题，Cglib是通过生成子类来实现的，代理对象既可以赋值给实现类，又可以赋值给接口。
//        Cglib速度比jdk动态代理更快，性能更好。


//JDK动态代理采用接口代理的模式，代理对象只能赋值给接口，允许多个接口
//        Cglib，Javassist，ByteBuddy这些都是采用了子类代理的模式，代理对象既可以赋值给接口，又可以复制给具体实现类
//        Spring5.X，Springboot2.X只有都采用了Cglib作为动态代理的实现，那是不是cglib性能是最好的呢？