package com.example.demo.cachestorage;

import com.example.demo.cacheexceptions.CacheKeyNotFoundException;
import com.example.demo.cacheexceptions.CacheStorageFullException;

import java.util.HashMap;
import java.util.Map;

public class MapBasedCacheStorage<CacheKey, CacheValue> implements CacheStorage<CacheKey, CacheValue>{

    Map<CacheKey, CacheValue> storage;
    private final Integer capacity;

    public MapBasedCacheStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void addInCache(CacheKey key, CacheValue value) throws CacheStorageFullException {
        if (isCacheStorageFull()) throw new CacheStorageFullException("Capacity Full.....");
        storage.put(key, value);
    }

    @Override
    public void removeFromCache(CacheKey key) throws CacheKeyNotFoundException {
        if (!storage.containsKey(key)) throw new CacheKeyNotFoundException(key + "doesn't exist in cache.");
        storage.remove(key);
    }

    @Override
    public CacheValue getFromCache(CacheKey key) throws CacheKeyNotFoundException {
        if (!storage.containsKey(key)) throw new CacheKeyNotFoundException(key + "doesn't exist in cache.");
        return storage.get(key);
    }

    @Override
    public Integer getCacheSize() {
        return storage.size();
    }

    private boolean isCacheStorageFull() {
        return storage.size() == capacity;
    }
}
