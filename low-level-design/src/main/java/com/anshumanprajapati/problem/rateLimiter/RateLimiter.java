package com.anshumanprajapati.problem.rateLimiter;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
