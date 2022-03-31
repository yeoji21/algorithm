package thinkDataStructures.ch12;

import java.util.*;

public class MyTreeMap<K, V> implements Map<K, V> {
    private int size = 0;
    private Node root = null;

    protected class Node{
        public K key;
        public V value;
        public Node left = null;
        public Node right = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return findNode(key) != null;
    }

    private Node findNode(Object target) {
        if(target == null) throw new IllegalArgumentException();

        Comparable<? super K> k = (Comparable<? super K>) target;
        // TODO: 2022/03/31
        return null;
    }

    private boolean equals(Object target, Object obj) {
        if (target == null) return obj == null;
        return target.equals(obj);
    }

    @Override
    public boolean containsValue(Object value) {
        return containsValueHelper(root, value);
    }

    private boolean containsValueHelper(Node root, Object target) {
        // TODO: 2022/03/31
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(Object key) {
        Node node = findNode(key);
        if(node == null) return null;
        return node.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new LinkedHashSet<>();
        // TODO: 2022/03/31
        return set;
    }

    @Override
    public V put(K key, V value) {
        if(key == null) throw new NullPointerException();
        if(root == null){
            root = new Node(key, value);
            size++;
            return null;
        }
        return putHelper(root, key, value);
    }


    private V putHelper(Node root, K key, V value) {
        // TODO: 2022/03/31
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        map.forEach(this::put);
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<V> values() {
        HashSet<V> set = new HashSet<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if(node == null) continue;
            set.add(node.value);
            stack.push(node.left);
            stack.push(node.right);
        }
        return set;
    }
}
