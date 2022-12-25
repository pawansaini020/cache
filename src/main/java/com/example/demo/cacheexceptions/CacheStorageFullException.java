package com.example.demo.cacheexceptions;

public class CacheStorageFullException extends RuntimeException {

    public CacheStorageFullException(String message) {
        super(message);
    }
}
