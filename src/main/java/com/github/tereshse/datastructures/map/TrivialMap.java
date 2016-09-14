package com.github.tereshse.datastructures.map;

public interface TrivialMap<K,V> {
    /**
     * Return the value associated with the given key. If the key does not exist then return null.
     *
     * @param key key to lookup
     * @return value associated with key; null if none exists
     * @throws NullPointerException if key is null
     */
    public V get(K key);

    /**
     * Add the key-value pair to the hashtable. If the key already exists, it's value will be
     * overwritten. Key and value must be non-null.
     *
     * @param  key the key
     * @param value the value
     * @throws NullPointerException if key or value are null
     */
    public void put(K key, V value);
}
