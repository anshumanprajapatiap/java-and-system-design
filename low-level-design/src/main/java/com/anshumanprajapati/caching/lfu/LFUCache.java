package com.anshumanprajapati.caching.lfu;

import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer, Node> keyMap;
    Map<Integer, Pair<Integer, Pair<Node, Node>>> freqMap;
    int capacity;
    public LFUCache(int cap){
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = cap;
    }

    public void init(int freq){
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        head.next = tail;;
        tail.prev = head;
        freqMap.put(freq, new Pair<>(0, new Pair<>(head, tail)));
    }

    public int get(int key){
        if(!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        int currentFreq = node.cnt + 1;
        node.cnt +=1;
        if(!freqMap.containsKey(currentFreq)){
            init(currentFreq);
        }
        Node head = freqMap.get(currentFreq).b.a;
        insert(head, node);
        return node.value;
    }


    public void insert(Node head, Node node){
        keyMap.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
