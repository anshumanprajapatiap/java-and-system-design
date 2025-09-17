package com.anshumanprajapati.others.machinecoding.cache;

import com.anshumanprajapati.others.machinecoding.model.Movie;

import java.util.HashMap;
import java.util.Map;

public class L2Cache implements Cache<Integer, Movie> {
    private final int MAX_ENTRIES = 20;
    private Map<Integer, Movie> cache;
    private Map<Integer, Integer> frequency; // Stores the frequency of each movie in cache

    public L2Cache() {
        this.cache = new HashMap<>();
        this.frequency = new HashMap<>();
    }

    @Override
    public Movie get(Integer key) {
        if (cache.containsKey(key)) {
            // Increment frequency for LFU eviction policy
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
            return cache.get(key);  // Return movie if found, else null
        }
        return null;
    }

    @Override
    public void put(Integer key, Movie value) {
        if (cache.size() >= MAX_ENTRIES) {
            evictLFU();  // Evict the least frequently used entry if the cache is full
        }
        cache.put(key, value);
        frequency.put(key, frequency.getOrDefault(key, 0) + 1);
    }

    @Override
    public void remove(Integer key) {
        cache.remove(key);
        frequency.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
        frequency.clear();
    }

    @Override
    public int getCacheHits() {
        // Return the number of cache hits (this should track hits, this is a placeholder).
        return 0;  // Placeholder for cache hit tracking
    }

    private void evictLFU() {
        // Find the movie with the lowest frequency
        Integer lfuKey = null;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                lfuKey = entry.getKey();
            }
        }

        // Evict the LFU entry from cache and frequency map
        if (lfuKey != null) {
            cache.remove(lfuKey);
            frequency.remove(lfuKey);
        }
    }
}
