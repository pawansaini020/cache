package com.example.demo;

import com.example.demo.factory.CacheFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {

    @Test
    public void getPutKeyValueTest() {

        Cache<Integer, Integer> cache = new CacheFactory<Integer, Integer>().defaultCache(15);
        cache.put(5, 10);
        cache.put(10, 25);

        assertEquals(10, cache.get(5));
        cache.put(15, 45);
        assertEquals(45, cache.get(15));

        cache.put(20, 55);

        cache.get(10);
    }

    @Test
    public void shouldReturnTrueIfKeyExist() {

        Cache<Integer, Integer> cache = new CacheFactory<Integer, Integer>().defaultCache(15);
        cache.put(5, 10);
        cache.put(10, 25);


        assertEquals(true, cache.delete(10));
    }

    @Test
    public void shouldReturnFasleIfKeyExist() {

        Cache<Integer, Integer> cache = new CacheFactory<Integer, Integer>().defaultCache(15);
        cache.put(5, 10);


        assertEquals(true, cache.delete(10));
    }
}
