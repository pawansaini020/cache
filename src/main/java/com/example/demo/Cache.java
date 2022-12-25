package com.example.demo;

import com.example.demo.cacheexceptions.CacheKeyNotFoundException;
import com.example.demo.cacheexceptions.CacheStorageFullException;
import com.example.demo.cachepolicy.CacheEvictionPolicy;
import com.example.demo.cachestorage.CacheStorage;

public class Cache<CacheKey, CacheValue> {

    private final CacheEvictionPolicy<CacheKey> evictionPolicy;
    private final CacheStorage<CacheKey, CacheValue> storage;

    public Cache(CacheEvictionPolicy<CacheKey> evictionPolicy, CacheStorage<CacheKey, CacheValue> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(CacheKey key, CacheValue value) {
        try {
            this.storage.addInCache(key, value);
            this.evictionPolicy.keyAccessed(key);
            System.out.println("Successfully added in cache key : " + key + " , value : "+value);
        } catch (CacheStorageFullException exception) {
            System.out.println("Got storage full. Will try to evict.");
            CacheKey keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            this.storage.removeFromCache(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key, value);
        }
    }

    public CacheValue get(CacheKey key) {
        try {
            CacheValue value = this.storage.getFromCache(key);
            this.evictionPolicy.keyAccessed(key);
            System.out.println("Successfully returned cache key : " + key + " , value : "+value);
            return value;
        } catch (CacheKeyNotFoundException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }

    public Boolean delete(CacheKey key) {
        try {
            this.storage.removeFromCache(key);
            System.out.println("Successfully deleted cache key : " + key);
            return true;
        } catch (CacheKeyNotFoundException notFoundException) {
            System.out.println("Tried to delete non-existing key.");
            return false;
        }
    }

    public Integer getCacheSize() {
        try {
            Integer size = this.storage.getCacheSize();
            System.out.println("Cache size is : " + size);
            return size;
        } catch (Exception e) {
            System.out.println("Unable to fetch cache size.");
            return 0;
        }
    }
}
