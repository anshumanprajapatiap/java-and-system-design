package com.anshumanprajapati.others.machinecoding.cache;

import com.anshumanprajapati.others.machinecoding.model.Movie;


import java.util.*;
import java.util.stream.Collectors;

public class CacheManager {
    private Map<Integer, Cache> userCaches;  // Maps userId to their L1 cache
    private Cache globalCache;  // L2 Cache
    private Map<Integer, Movie> primaryStore;  // Primary Store (In-memory)
    private int totalSearches;

    public CacheManager() {
        this.userCaches = new HashMap<>();
        this.globalCache = new CacheStatsDecorator(new L2Cache());  // Wrap L2 cache with stats
        this.primaryStore = new HashMap<>();
        this.totalSearches = 0;
    }

    public void addMovie(Movie movie) {
        primaryStore.put(movie.getId(), movie);
    }

    public void registerUser(int userId) {
        userCaches.put(userId, new CacheStatsDecorator(new L1Cache()));  // Wrap L1 cache with stats
    }

    public Movie search(int userId, int movieId) {
        totalSearches++;
        Cache userCache = userCaches.get(userId);
        Movie movie = (Movie) userCache.get(movieId);

        if (movie == null) {
            movie = (Movie) globalCache.get(movieId);
            if (movie == null) {
                movie = primaryStore.get(movieId);
                if (movie != null) {
                    globalCache.put(movieId, movie);
                    userCache.put(movieId, movie);
                }
            } else {
                userCache.put(movieId, movie);
            }
        }

        return movie;
    }

    public List<String> search(int userId, String searchType, String searchValue) {
        totalSearches++;
        List<String> result = new ArrayList<>();
        Cache userCache = userCaches.get(userId);

        // Search based on the type
        List<Movie> moviesToSearch = new ArrayList<>();
        if ("GENRE".equalsIgnoreCase(searchType)) {
            moviesToSearch = searchByGenre(searchValue);
        } else if ("TITLE".equalsIgnoreCase(searchType)) {
            moviesToSearch = searchByTitle(searchValue);
        }

        for (Movie movie : moviesToSearch) {
            String cacheLevel = "Primary Store";
            if (userCache.get(movie.getId()) != null) {
                cacheLevel = "L1 Cache";
            } else if (globalCache.get(movie.getId()) != null) {
                cacheLevel = "L2 Cache";
            }
            result.add(movie + " (Found in " + cacheLevel + ")");
        }

        return result;
    }

    private List<Movie> searchByGenre(String genre) {
        // Search in primary store, L2 cache, and then L1 cache
        List<Movie> allMovies = new ArrayList<>(primaryStore.values());
        return allMovies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    private List<Movie> searchByTitle(String title) {
        // Search in primary store, L2 cache, and then L1 cache
        List<Movie> allMovies = new ArrayList<>(primaryStore.values());
        return allMovies.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<String> searchMulti(int userId, String genre, int year, double minRating) {
        totalSearches++;
        List<String> result = new ArrayList<>();
        Cache userCache = userCaches.get(userId);

        // Filter the movies based on multiple criteria
        List<Movie> moviesToSearch = searchByGenre(genre).stream()
                .filter(movie -> movie.getReleaseYear() == year)
                .filter(movie -> movie.getRating() >= minRating)
                .collect(Collectors.toList());

        for (Movie movie : moviesToSearch) {
            String cacheLevel = "Primary Store";
            if (userCache.get(movie.getId()) != null) {
                cacheLevel = "L1 Cache";
            } else if (globalCache.get(movie.getId()) != null) {
                cacheLevel = "L2 Cache";
            }
            result.add(movie + " (Found in " + cacheLevel + ")");
        }

        return result;
    }

    public void viewCacheStats() {
        int l1Hits = ((CacheStatsDecorator) userCaches.values().toArray()[0]).getCacheHits(); // Assumes at least 1 user
        int l2Hits = ((CacheStatsDecorator) globalCache).getCacheHits();

        System.out.println("L1 Cache Hits: " + l1Hits);
        System.out.println("L2 Cache Hits: " + l2Hits);
        System.out.println("Primary Store Hits: " + (totalSearches - l1Hits - l2Hits));
        System.out.println("Total Searches: " + totalSearches);
    }
}
