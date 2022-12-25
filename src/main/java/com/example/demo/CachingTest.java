package com.example.demo;

import com.example.demo.factory.CacheFactory;

public class CachingTest {

    public void test(){
        Cache<Integer, Integer> cache = new CacheFactory<Integer, Integer>().defaultCache(3);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(2));

    }


}
