package com.anshumanprajapati.others.machinecoding;

import com.anshumanprajapati.others.machinecoding.cache.CacheManager;
import com.anshumanprajapati.others.machinecoding.model.Movie;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CacheManager cacheManager = new CacheManager();

        // Register users
        cacheManager.registerUser(1);

        // Add movies to primary store
        cacheManager.addMovie(new Movie(1, "Inception", "Sci-Fi", 2010, 9.5));
        cacheManager.addMovie(new Movie(2, "Titanic", "Romance", 1997, 7.8));
        cacheManager.addMovie(new Movie(3, "Avatar", "Action", 2009, 8.0));
        cacheManager.addMovie(new Movie(4, "The Dark Knight", "Action", 2008, 9.0));
        cacheManager.addMovie(new Movie(5, "The Matrix", "Sci-Fi", 1999, 8.7));
        cacheManager.addMovie(new Movie(3, "Fight", "Action", 2009, 8.0));

        // Search by genre
        System.out.println(cacheManager.search(1, "GENRE", "Action"));

        // Search by title
        System.out.println(cacheManager.search(1, "TITLE", "Inception"));

        // Search with multiple filters
        List<String> multiSearchResults = cacheManager.searchMulti(1, "Action", 2009, 8.0);
        for (String s : multiSearchResults) {
            System.out.println(s);
        }

        // View cache stats
        cacheManager.viewCacheStats();  // Displays cache hit stats
    }
}
