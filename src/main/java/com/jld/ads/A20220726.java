package com.jld.ads;

public class A20220726 {
}

class LRUCache {

    static class Cell {
        int value;
        Cell next;
        Cell last;

        public Cell() {
        }

        public Cell(int value, Cell next, Cell last) {
            this.value = value;
            this.next = next;
            this.last = last;
        }
    }

    static class Hashtable {
        int[] key;
        Cell[] cells;
        int capacity;

        public Hashtable(int capacity) {
            this.key = new int[capacity + 1];
            this.cells = new Cell[capacity + 1];
            this.capacity = capacity;
        }
    }

    Hashtable hashtable;
    Cell head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.hashtable = new Hashtable(capacity);
        this.head = this.tail = hashtable.cells[1];
        this.capacity = capacity;
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {
        int hash = key % (this.capacity + 1);
        if (hash <= this.hashtable.capacity) {
            if (this.hashtable.cells[hash] == null) {
                if (head == null) {
                    head = new Cell(value, null, null);
                    head.next = head.last = head;
                    tail = head;
//                    this.hashtable.cells[hash] = 1;
                } else {
                    Cell temp = new Cell(value, tail.next, tail);
                    tail.next = temp;
                    tail = temp;
                }
            } else {
//                Cell temp =
            }
        }
    }
}
/*
  Your com.jld.ads.LRUCache object will be instantiated and called as such:
  com.jld.ads.LRUCache obj = new com.jld.ads.LRUCache(capacity);
  int param_1 = obj.get(key);
  obj.put(key,value);
 */