package com.anshumanprajapati.problem.rateLimiter;

import lombok.Data;

import java.time.Instant;
import java.util.*;

@Data
public class User {
    private String userId;
    private Queue<Instant> requestTimestamps;
    private int limit;

    User(String userId, int limit){
        this.userId = userId;
        this.requestTimestamps = new LinkedList<>();
        this.limit = limit;
    }
}
