package thinkDataStructures.ch11;

import thinkDataStructures.ch9.MyBetterMap;
import thinkDataStructures.ch9.MyLinearMap;

import java.util.List;
import java.util.Map;

public class MyHashMap<K, V> extends MyBetterMap<K, V> implements Map<K, V> {
    protected static final double FACTOR = 1.0;

    public MyHashMap() {
        super();
    }

    public MyHashMap(int k) {
        super(k);
    }

    @Override
    public V put(K key, V value) {
        V oldValue = super.put(key, value);
        if(size() > maps.size() * FACTOR) rehash();
        return oldValue;
    }

    protected void rehash() {
        List<MyLinearMap<K, V>> oldMaps = this.maps;
        makeMaps(maps.size() * 2);
        oldMaps.forEach(map -> map.getEntries().forEach(e -> put(e.getKey(), e.getValue())));
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new MyHashMap<>();
        for (int i=0; i<10; i++) map.put(Integer.toString(i), i);
        System.out.println(map.get("3"));
    }
}
