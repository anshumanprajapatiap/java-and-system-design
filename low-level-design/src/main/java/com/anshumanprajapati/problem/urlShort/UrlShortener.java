package com.anshumanprajapati.problem.urlShort;

import com.anshumanprajapati.problem.urlShort.strategy.Strategy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UrlShortener {

    private String BASE_HOST;
    private Strategy strategy;
    private ConcurrentMap<String, String> shortToLong;
    private ConcurrentMap<String, String> longToShort;

    UrlShortener(String BASE_HOST, Strategy strategy){
        this.BASE_HOST = BASE_HOST;
        this.strategy = strategy;
        this.shortToLong = new ConcurrentHashMap<>();
        this.longToShort = new ConcurrentHashMap<>();
    }


    public String shortenUrl(String longUrl){
        if(longToShort.containsKey(longUrl)) return BASE_HOST + longToShort.get(longUrl);

        String shortKey = strategy.encode(longUrl);
        shortToLong.put(shortKey, longUrl);
        longToShort.put(longUrl, shortKey);
        return BASE_HOST + shortKey;
    }

    public String getOriginalUrl(String shortUrl) {
        String key = shortUrl.replace(BASE_HOST, "");
        return shortToLong.getOrDefault(key, "URL not found");
    }

}
