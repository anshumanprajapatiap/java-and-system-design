package com.anshumanprajapati.problem.urlShort;

import com.anshumanprajapati.problem.urlShort.factory.StrategyFactory;
import com.anshumanprajapati.problem.urlShort.strategy.Base62;

public class Main {

    public static void main(String[] args) {
        StrategyFactory factory = new StrategyFactory();

        UrlShortener urlShortener = new UrlShortener(
                "http://short.url/",
                factory.getStrategy("BASE62"));

        String longUrl = "https://www.example.com/some/very/long/path";
        String shortUrl = urlShortener.shortenUrl(longUrl);
        System.out.println("Shortened URL: " + shortUrl);

        String originalUrl = urlShortener.getOriginalUrl(shortUrl);
        System.out.println("Original URL: " + originalUrl);

        String longUrl2 = "https://www.example.com/some/very/long/path2";
        String shortUrl2 = urlShortener.shortenUrl(longUrl2);
        System.out.println("Shortened URL: " + shortUrl2);

        String originalUrl2 = urlShortener.getOriginalUrl(shortUrl2);
        System.out.println("Original URL: " + originalUrl2);
    }
}
