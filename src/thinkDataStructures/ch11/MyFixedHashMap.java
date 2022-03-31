package thinkDataStructures.ch11;

import thinkDataStructures.ch9.MyLinearMap;

import java.util.Map;

public class MyFixedHashMap<K, V> extends MyHashMap<K, V> implements Map<K, V> {
    private int size = 0;

    @Override
    public void clear() {
        super.clear();
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        MyLinearMap<K, V> map = chooseMap(key);
        size -= map.size();
        V oldValue = map.put(key, value);
        size += map.size();

        if(size() > map.size() * FACTOR){
            size = 0;
            rehash();
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        size -= map.size();
        V oldValue = map.remove(key);
        size += map.size();
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }
}
