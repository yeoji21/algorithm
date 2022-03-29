package thinkDataStructures.ch9;

import java.util.*;

public class MyBetterMap<K, V> implements Map<K, V> {
    protected List<MyLinearMap<K, V>> maps;

    public MyBetterMap(int k) {
        makeMaps(k);
    }

    private void makeMaps(int k) {
        maps = new ArrayList<>(k);
        for (int i = 0; i < k; i++) maps.add(new MyLinearMap<>());
    }

    protected MyLinearMap<K, V> chooseMap(Object key) {
        int index = 0;
        if (key != null) {
            index = Math.abs(key.hashCode()) % maps.size();
        }
        return maps.get(index);
    }

    @Override
    public int size() {
        int total = 0;
        for (MyLinearMap<K, V> map : maps) total += map.size();
        return total;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return chooseMap(key).containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return maps.stream().anyMatch(m -> m.containsValue(value));
    }

    @Override
    public V get(Object key) {
        return chooseMap(key).get(key);
    }

    @Override
    public V put(K key, V value) {
        return chooseMap(key).put(key, value);
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        map.forEach(this::put);
    }

    @Override
    public void clear() {
        maps.forEach(Map::clear);
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        maps.forEach(m -> set.addAll(m.keySet()));
        return set;
    }

    @Override
    public Collection<V> values() {
        Set<V> set = new HashSet<>();
        maps.forEach(m -> set.addAll(m.values()));
        return set;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        maps.forEach(m -> m.entrySet().forEach(set::add));
        return set;
    }
}
