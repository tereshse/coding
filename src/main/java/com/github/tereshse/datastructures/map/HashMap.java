package com.github.tereshse.datastructures.map;


import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements TrivialMap<K, V> {
    private List<Pair<K, V>>[] storage;

    public HashMap() {
        this(1000);
    }

    public HashMap(int initialCapacity) {
        this.storage = (List<Pair<K, V>>[]) new List[initialCapacity];
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("Key must be not null");
        }
        Pair<K, V> pair = getPair(key);
        if (pair == null) {
            return null;
        } else {
            return pair.getValue();
        }
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Key must be not null");
        }
        if (value == null) {
            throw new NullPointerException("Value must be not null");
        }
        int bucketIndex = calculateBucketIndex(key);
        if (this.storage[bucketIndex] == null) {
            this.storage[bucketIndex] = new ArrayList<>();
        }

        Pair<K, V> pair = getPair(key);
        if (pair == null) {
            this.storage[bucketIndex].add(Pair.of(key, value));
        } else {
            pair.setValue(value);
        }
    }

    private Pair<K, V> getPair(K key) {
        List<Pair<K, V>> chain = this.storage[calculateBucketIndex(key)];
        if (chain == null) {
            return null;
        }
        for (Pair<K, V> keyValuePair : chain) {
            if (keyValuePair.getKey().equals(key)) {
                return keyValuePair;
            }
        }
        return null;
    }

    private int calculateBucketIndex(K key) {
        return key.hashCode() % this.storage.length;
    }
}
