package com.jld.designpattern;

import java.util.ArrayList;
import java.util.List;

public class _13_CompositePattern {
    //合模式（Composite Pattern），又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。
    // 组合模式依据树形结构来组合对象，用来表示部分以及整体层次。
    // 这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。 这种模式创建了一个包含自己对象组的类。
    //需要分组实体，composite、leaf，由component统一规范调用屏蔽细节

    public abstract static class Component {
        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public abstract void operation();

        public void add(Component c) {
            throw new UnsupportedOperationException();
        }

        public void remove(Component c) {
            throw new UnsupportedOperationException();
        }

        public Component getChild(int i) {
            throw new UnsupportedOperationException();
        }

        public List<Component> getChildren() {
            return null;
        }
    }


    public static class Composite extends Component {
        private List<Component> components = new ArrayList<>();

        public Composite(String name) {
            super(name);
        }

        @Override
        public void operation() {
            System.out.println("组合节点" + name + "的操作");
            //调用所有子节点的操作
            for (Component component : components) {
                component.operation();
            }
        }

        @Override
        public void add(Component c) {
            components.add(c);
        }

        @Override
        public void remove(Component c) {
            components.remove(c);
        }

        @Override
        public Component getChild(int i) {
            return components.get(i);
        }

        @Override
        public List<Component> getChildren() {
            return components;
        }
    }

    public static class Leaf extends Component {

        public Leaf(String name) {
            super(name);
        }

        @Override
        public void operation() {
            System.out.println("叶节点" + name + "的操作");
        }
    }

    public static void main(String[] args) {
        //创建根节点对象
        Component component = new Composite("component");

        //创建两个组合节点对象
        Component composite1 = new Composite("composite1");
        Component composite2 = new Composite("composite2");

        //将两个组合节点对象添加到根节点
        component.add(composite1);
        component.add(composite2);

        //给第一个组合节点对象添加两个叶子节点
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");
        composite1.add(leaf1);
        composite1.add(leaf2);

        //给第二个组合节点对象添加一个叶子节点和一个组合节点
        Component leaf3 = new Leaf("leaf3");
        Component composite3 = new Composite("composite3");
        composite2.add(leaf3);
        composite2.add(composite3);

        //给第二个组合节点下面的组合节点添加两个叶子节点
        Component leaf4 = new Leaf("leaf4");
        Component leaf5 = new Leaf("leaf5");
        composite3.add(leaf4);
        composite3.add(leaf5);

        //执行所有节点的操作
        component.operation();
    }


}
