package com.anshumanprajapati.problem.rateLimiter;

import java.time.Duration;
import java.util.*;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterStrategy implements RateLimiter{
    ConcurrentHashMap<String, User> userMap;
    private final int limit;          // max allowed requests
    private final int timeWindowSec;  // time window in seconds

    RateLimiterStrategy(int limit, int timeWindowSec){
        this.limit = limit;
        this.timeWindowSec = timeWindowSec;
        this.userMap = new ConcurrentHashMap<>();
    }
    @Override
    public boolean allowRequest(String userId) {
        Instant now = Instant.now();
        userMap.putIfAbsent(userId, new User(userId, limit));
        User user = userMap.get(userId);

        synchronized (user){

            Queue<Instant> requests = user.getRequestTimestamps();

            while (!requests.isEmpty() && Duration.between(requests.peek(), now).getSeconds() >= timeWindowSec) {
                requests.poll();
            }

            if (requests.size() < limit) {
                requests.offer(now); // accept request
                return true;
            }

            return false; // reject request

        }
    }
}
