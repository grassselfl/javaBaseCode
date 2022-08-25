package com.jld.designpattern;

public class _16_StrategyPattern {
    //意图
    //定义一系列算法，封装每个算法，并使它们可以互换。
    //
    //策略模式可以让算法独立于使用它的客户端

    //例如。负载均衡和其规则，轮询、hash、就近轮询规则

    //与状态模式的比较
    //状态模式的类图和策略模式类似，并且都是能够动态改变对象的行为。
    // 但是状态模式是通过状态转移来改变 Context 所组合的 State 对象，而策略模式是通过 Context 本身的决策来改变组合的 Strategy 对象。
    // 所谓的状态转移，是指 Context 在运行过程中由于一些条件发生改变而使得 State 对象发生改变，注意必须要是在运行过程中。
    //
    //状态模式主要是用来解决状态转移的问题，当状态发生转移了，那么 Context 对象就会改变它的行为；
    // 而策略模式主要是用来封装一组可以互相替代的算法族，并且可以根据需要动态地去替换 Context 使用的算法。

    public interface Rule{
        void exec();
    }

    public static class RoundRobin implements Rule{
        @Override
        public void exec() {
            System.out.println("RoundRobin");
        }
    }
    public static class Hash implements Rule{
        @Override
        public void exec() {
            System.out.println("Hash");
        }
    }

    public static class LoadBalance{
        private Rule rule;
        public void performLoadBalanceStrategy(){
            if (rule!=null)rule.exec();
            else throw new RuntimeException("未配置负载均衡策略");
        }

        public void setRule(Rule rule){
            this.rule=rule;
        }
    }

    public static void main(String[] args) {
        LoadBalance loadBalance = new LoadBalance();
        loadBalance.setRule(new Hash());
        loadBalance.performLoadBalanceStrategy();
    }

    //java.util.Comparator#compare()
    //javax.servlet.Filter#doFilter()
}
