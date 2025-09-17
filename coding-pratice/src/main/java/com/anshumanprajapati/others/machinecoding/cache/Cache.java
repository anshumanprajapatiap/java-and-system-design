package com.anshumanprajapati.others.machinecoding.cache;


public interface Cache<K, V> {
    V get(K key);             // Fetch the value by key
    void put(K key, V value); // Put a key-value pair into the cache
    void remove(K key);       // Remove the key-value pair from the cache
    void clear();             // Clear the cache
    int getCacheHits();       // Return the number of cache hits
}
