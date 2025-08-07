package com.anshumanprajapati.problem.rateLimiter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiterStrategy(1, 1);

        System.out.println(rateLimiter.allowRequest("1"));

        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // good practice
        }

        System.out.println(rateLimiter.allowRequest("1"));

    }
}
