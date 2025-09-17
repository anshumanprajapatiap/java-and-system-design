package com.anshumanprajapati.others.machinecoding.cache;

import com.anshumanprajapati.others.machinecoding.model.Movie;

import java.util.LinkedHashMap;
import java.util.Map;

public class L1Cache implements Cache<Integer, Movie> {
    private final int MAX_ENTRIES = 5;
    private Map<Integer, Movie> cache;

    public L1Cache() {
        this.cache = new LinkedHashMap<Integer, Movie>(MAX_ENTRIES, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Movie> eldest) {
                return size() > MAX_ENTRIES;  // Removes the eldest entry if the cache exceeds max size
            }
        };
    }

    @Override
    public Movie get(Integer key) {
        return cache.get(key);  // Return movie if found, else null
    }

    @Override
    public void put(Integer key, Movie value) {
        cache.put(key, value);  // Add movie to cache
    }

    @Override
    public void remove(Integer key) {
        cache.remove(key);  // Remove movie from cache
    }

    @Override
    public void clear() {
        cache.clear();  // Clear all movies in the cache
    }

    @Override
    public int getCacheHits() {
        // Return the cache hit count. Here we don't track hits, but this can be implemented.
        return 0;  // Placeholder for cache hit tracking
    }
}
