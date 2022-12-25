package com.example.demo;

import com.example.demo.cachepolicy.LRUEvictionCachePolicy;
import com.example.demo.factory.CacheFactory;

public class CachingTest {

    public void test(){
        Cache<Integer, Integer> cache = new CacheFactory<Integer, Integer>().defaultCache(5);

        //cache test
        cache.put(5, 10);
        cache.put(7, 50);

        cache.getCacheSize();

        cache.get(7);

        cache.delete(7);
        cache.get(7);
        cache.delete(7);

        cache.getCacheSize();

        // lru policy test
        LRUEvictionCachePolicy<Integer> lruEvictionCachePolicy = new LRUEvictionCachePolicy<>();
        lruEvictionCachePolicy.keyAccessed(1);
        lruEvictionCachePolicy.keyAccessed(2);
        lruEvictionCachePolicy.keyAccessed(3);
        lruEvictionCachePolicy.keyAccessed(4);
        lruEvictionCachePolicy.keyAccessed(2);
        lruEvictionCachePolicy.evictKey();
        lruEvictionCachePolicy.evictKey();
        lruEvictionCachePolicy.evictKey();
    }


}
