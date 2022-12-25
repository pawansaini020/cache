package com.example.demo.cacheexceptions;

public class CacheKeyNotFoundException extends RuntimeException {

    public CacheKeyNotFoundException(final String message) {
        super(message);
    }
}
