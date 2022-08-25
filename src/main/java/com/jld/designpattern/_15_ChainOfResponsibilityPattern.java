package com.jld.designpattern;

public class _15_ChainOfResponsibilityPattern {
    //使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
    // 将这些对象连成一条链，并沿着这条链发送该请求，直到有一个对象处理它为止

    public enum RequestType {
        type1, type2
    }

    public static class Request {
        private RequestType type;
        private String name;

        public Request(RequestType type, String name) {
            this.type = type;
            this.name = name;
        }

        public RequestType getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    public static abstract class Handler {
        protected Handler successor;

        public Handler(Handler successor) {
            this.successor = successor;
        }

        protected abstract void handleRequest(Request request);
    }

    public static class ConcreteHandler1 extends Handler {
        public ConcreteHandler1(Handler successor) {
            super(successor);
        }

        @Override
        protected void handleRequest(Request request) {
            if (request.getType() == RequestType.type1) {
                System.out.println(request.getName() + " is handle by ConcreteHandler1");
                return;
            }
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }

    public static class ConcreteHandler2 extends Handler {
        public ConcreteHandler2(Handler successor) {
            super(successor);
        }

        @Override
        protected void handleRequest(Request request) {
            if (request.getType() == RequestType.type2) {
                System.out.println(request.getName() + " is handle by ConcreteHandler2");
                return;
            }
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);
        Request request1 = new Request(RequestType.type1, "request1");
        handler2.handleRequest(request1);
        Request request2 = new Request(RequestType.type2, "request2");
        handler2.handleRequest(request2);

        //先添加的处理器先进行处理
        //javax.servlet.Filter#doFilter()
    }
}
