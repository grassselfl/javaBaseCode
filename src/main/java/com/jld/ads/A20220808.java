package com.jld.ads;

class Node {
    public int data;
    public Node next;
    public Node bro;

    public Node(int data, Node next, Node bro) {
        this.data = data;
        this.next = next;
        this.bro = bro;
    }

    public Node() {
    }
}
//关系深拷贝·
public class A20220808 {
    public static Node main(String[] args) {
        Node header = new Node();
        Node newHeader;
        if (header != null) {
            newHeader = new Node(header.data, header.next, header.bro);
        } else return null;
        Node temp = newHeader;
        while (header.next != null) {
            Node node = new Node(header.next.data, header.next.next, header.next.bro);
            temp.next = node;//
            temp = temp.next;
            header = header.next;
        }

        return newHeader;
    }
    //深拷贝重点在于指针的修改
}
