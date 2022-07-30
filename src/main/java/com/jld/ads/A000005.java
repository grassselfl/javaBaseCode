package com.jld.ads;

/**
 * 算法题：有序链表合并
 */
public class A000005 {

    static class  Node {
        int value;
        Node next;

        public Node(Node next) {
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    public static Node cal(Node l1, Node l2) {
        Node head = new Node();
        Node headTemp = head;
        Node temp1 = new Node(l1), temp2 = new Node(l2);

        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else {
            while (temp1.next != null || temp2.next != null) {

                if (temp1.next.value < temp2.next.value) {
                    headTemp.next = temp1.next;
                    temp1 = temp1.next;
                } else {
                    headTemp.next = temp2.next;
                    temp2 = temp2.next;
                }
                headTemp = headTemp.next;
            }
            if (temp1 != null) {
                headTemp.next = temp1;
            }
            if (temp2 != null) {
                headTemp.next = temp2;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next=new Node(3);
        l1.next.next=new Node(5);


        Node l2 = new Node(2);
        l2.next=new Node(3);
        l2.next.next=new Node(6);

        Node node = cal(l1,l2);

        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }

    }
}

