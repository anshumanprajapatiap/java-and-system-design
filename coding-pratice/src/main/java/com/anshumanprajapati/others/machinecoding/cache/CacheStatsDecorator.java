package com.anshumanprajapati.others.machinecoding.cache;

import com.anshumanprajapati.others.machinecoding.model.Movie;

public class CacheStatsDecorator implements Cache<Integer, Movie> {
    private final Cache<Integer, Movie> wrappedCache;
    private int cacheHits;

    public CacheStatsDecorator(Cache<Integer, Movie> wrappedCache) {
        this.wrappedCache = wrappedCache;
        this.cacheHits = 0;
    }

    @Override
    public Movie get(Integer key) {
        Movie movie = wrappedCache.get(key);
        if (movie != null) {
            cacheHits++;  // Track a cache hit
        }
        return movie;
    }

    @Override
    public void put(Integer key, Movie value) {
        wrappedCache.put(key, value);
    }

    @Override
    public void remove(Integer key) {
        wrappedCache.remove(key);
    }

    @Override
    public void clear() {
        wrappedCache.clear();
    }

    @Override
    public int getCacheHits() {
        return cacheHits;  // Return the number of cache hits
    }
}
