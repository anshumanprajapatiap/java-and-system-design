package com.anshumanprajapati.caching.lru;

public interface Cache<K, V> {
    V get();
    void put(K key, V value);
    void remove(K key);
}
