package com.jld.ads;

import java.util.HashMap;

/**
 * 算法题：环形链表
 */
public class A000013 {
    static class LinkNode {
        int value;
        LinkNode next;

        public LinkNode(LinkNode next) {
            this.next = next;
        }

        public LinkNode(int value, LinkNode next) {
            this.value = value;
            this.next = next;
        }

        public LinkNode(int value) {
            this.value = value;
        }
    }

    public static void cal() {
        LinkNode node1A = new LinkNode(4);
        LinkNode node2A = new LinkNode(1);


        LinkNode node1B = new LinkNode(5);
        LinkNode node2B = new LinkNode(0);
        LinkNode node3B = new LinkNode(1);

        LinkNode node4 = new LinkNode(8);
        LinkNode node5 = new LinkNode(4);
        LinkNode node6 = new LinkNode(5);

        node1A.next = node2A;
        node2A.next = node4;

        node1B.next = node2B;
        node2B.next = node3B;
        node3B.next = node4;

        node4.next = node5;
        node5.next = node6;


        HashMap<LinkNode, Integer> map = new HashMap<>();
        LinkNode temp = new LinkNode(node1A);
        while (temp.next != null) {
            map.put(temp.next, temp.next.value);
            temp = temp.next;
        }
        LinkNode temp2 = new LinkNode(node1B);
        while (temp2.next != null) {
            if (map.containsKey(temp2.next)) {
                System.out.println(temp2.next + " " + temp2.next.value);
                break;
            }
            temp2 = temp2.next;
        }
    }

    public static void main(String[] args) {
        cal();
    }

}
//    351
//    135
//    513
//
//    135
//    351
//    513
//    3   1   5
//    5   3   1
//    1   5   3


