package com.anshumanprajapati.caching.lfu;

public class Node {
    public int key;
    public int value;
    public int cnt;
    public Node next;
    public  Node prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.cnt = 1;
    }
}
