package com.anshumanprajapati.caching.lru;

public class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(){

    }

    Node(int key, int value, Node next, Node prev){
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
