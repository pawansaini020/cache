package com.example.demo;

import com.example.demo.cachepolicy.LRUEvictionCachePolicy;
import com.example.demo.factory.CacheFactory;

public class CachingTest {

    public void test(){
        Cache<Integer, Integer> cache = new CacheFactory<Integer, Integer>().defaultCache(5);

        //cache test
        cache.put(1, 10);
        cache.put(2, 20);

        cache.getCacheSize();

        cache.get(2);

        cache.delete(2);
        cache.get(2);
        cache.delete(2);

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
