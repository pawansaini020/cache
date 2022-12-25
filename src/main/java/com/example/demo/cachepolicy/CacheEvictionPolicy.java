package com.example.demo.cachepolicy;

public interface CacheEvictionPolicy<CacheKey> {

    void keyAccessed(CacheKey key);

    CacheKey evictKey();
}
