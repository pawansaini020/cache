package com.example.demo.cachepolicy;

import com.example.demo.cachepolicy.Lists.DoublyLinkedList;
import com.example.demo.cachepolicy.Lists.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionCachePolicy<CacheKey> implements CacheEvictionPolicy<CacheKey> {

    private DoublyLinkedList<CacheKey> dll;
    private Map<CacheKey, DoublyLinkedListNode<CacheKey>> mapper;

    public LRUEvictionCachePolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(CacheKey key) {
        System.out.println("Cache key accessed key : " + key);
        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<CacheKey> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public CacheKey evictKey() {

        DoublyLinkedListNode<CacheKey> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        System.out.println("Cache key evicted according to lru key : " + first.getElement());
        return first.getElement();
    }
}
