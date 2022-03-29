package thinkDataStructures.ch9;

import java.util.*;

public class MyLinearMap<K, V> implements Map<K, V> {
    private List<Entry> entries = new ArrayList<>();

    public class Entry implements Map.Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }
    }

    private Entry findEntry(Object target) {
        return entries.stream().filter(e -> equals(e.getKey(), target)).findAny().orElse(null);
    }

    private boolean equals(Object target, Object obj) {
        if (target == null) {
            return obj == null;
        }
        return target.equals(obj);
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return findEntry(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return entries.stream().anyMatch(e -> equals(e.getValue(), value));
    }

    @Override
    public V get(Object key) {
        return findEntry(key).getValue();
    }

    @Override
    public V put(K key, V value) {
        Entry entry = findEntry(key);
        if(entry == null){
            put(key, value);
            return null;
        }
        else{
            V oldValue = entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
    }

    @Override
    public V remove(Object key) {
        Entry entry = findEntry(key);
        if(entry == null) return null;
        else{
            V value = entry.getValue();
            entries.remove(entry);
            return value;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        map.forEach(this::put);
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        entries.forEach(e -> set.add(e.getKey()));
        return set;
    }

    @Override
    public Collection<V> values() {
        Set<V> set = new HashSet<>();
        entries.forEach(e -> set.add(e.getValue()));
        return set;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new HashSet<>(entries);
    }
}
