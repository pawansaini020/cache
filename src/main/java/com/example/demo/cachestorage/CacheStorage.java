package com.example.demo.cachestorage;

import com.example.demo.cacheexceptions.CacheKeyNotFoundException;
import com.example.demo.cacheexceptions.CacheStorageFullException;

public interface CacheStorage<CacheKey, CacheValue> {

    public void addInCache(CacheKey key, CacheValue value) throws CacheStorageFullException;

    void removeFromCache(CacheKey key) throws CacheKeyNotFoundException;

    CacheValue getFromCache(CacheKey key) throws CacheKeyNotFoundException;
}
