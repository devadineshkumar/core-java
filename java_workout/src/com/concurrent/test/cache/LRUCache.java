package com.concurrent.test.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void display() {
        System.out.println("Cache: " + cache);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lru = new LRUCache<>(3);
        lru.put(1, "A");
        lru.put(2, "B");
        lru.put(3, "C");
        lru.display(); // {1=A, 2=B, 3=C}

        lru.get(2);     // Access 2 to make it recently used
        lru.put(4, "D"); // Evicts 1 (least recently used)
        lru.display(); // {3=C, 2=B, 4=D}
    }
}
