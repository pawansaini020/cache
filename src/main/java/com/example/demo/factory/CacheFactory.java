package com.example.demo.factory;

import com.example.demo.Cache;
import com.example.demo.cachepolicy.LRUEvictionCachePolicy;
import com.example.demo.cachestorage.MapBasedCacheStorage;

public class CacheFactory<CacheKey, CachValue> {

    public Cache<CacheKey, CachValue> defaultCache(final int capacity) {
        return new Cache<CacheKey, CachValue>(new LRUEvictionCachePolicy<CacheKey>(),
                new MapBasedCacheStorage<CacheKey, CachValue>(capacity));
    }
}
