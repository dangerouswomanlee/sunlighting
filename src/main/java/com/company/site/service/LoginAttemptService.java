package com.company.site.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LoginAttemptService {

    private static final int MAX_ATTEMPTS = 5;
    private static final int LOCK_MINUTES = 10;

    private final Map<String, Integer> attempts = new ConcurrentHashMap<>();
    private final Map<String, LocalDateTime> lockTime = new ConcurrentHashMap<>();

    public boolean isBlocked(String username) {
        if (!lockTime.containsKey(username)) return false;
        if (LocalDateTime.now().isAfter(lockTime.get(username).plusMinutes(LOCK_MINUTES))) {
            reset(username);
            return false;
        }
        return true;
    }

    public void loginFailed(String username) {
        int count = attempts.getOrDefault(username, 0) + 1;
        attempts.put(username, count);
        if (count >= MAX_ATTEMPTS) {
            lockTime.put(username, LocalDateTime.now());
        }
    }

    public void reset(String username) {
        attempts.remove(username);
        lockTime.remove(username);
    }

    public int getRemainingAttempts(String username) {
        return MAX_ATTEMPTS - attempts.getOrDefault(username, 0);
    }
}
