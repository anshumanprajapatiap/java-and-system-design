package com.anshumanprajapati.caching.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache<K, V> implements  Cache<K, V>{
    Map<K, V> cacheMap;
    Node head;
    Node tail;
    int capacity;

    LRUCache(int capacity){
        this.cacheMap = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;;
        tail.prev = head;
    }


    @Override
    public V get() {
        return null;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }
}
