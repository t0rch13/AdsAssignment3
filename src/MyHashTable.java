import java.util.Arrays;

public class MyHashTable <K, V> {
    private class MyHashNode<K, V>{
        private K key;
        private V value;
        private MyHashNode<K, V> next;
        public  MyHashNode (K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{ " + key + " " + value + " }";
        }
    }

    private MyHashNode<K, V>[] buckets; // array of hash nodes
    private int capacity;
    private int size; //num of key-value pairs

    public MyHashTable(){
        this(11); //default capacity
    }

    public MyHashTable(int initialCapacity){
        capacity = initialCapacity;
        buckets = new MyHashNode[capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    public int hash(K key){
        return key.hashCode() % capacity;
    }

    public V get(K key){
        int hash = hash(key);
        MyHashNode<K,V> node = buckets[hash];
        while(node != null){
            if(node.key == key){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void put(K key, V value){
        size++;
        int hash = hash(key);
        MyHashNode<K,V> newNode = new MyHashNode<>(key, value);
        newNode.next = buckets[hash];
        buckets[hash] = newNode;
    }

    public V remove(K key){
        int hash = hash(key);
        MyHashNode<K,V> node = buckets[hash];
        if(node == null){
            return null;
        }
        while(node.next != null){
            if(node.key == key){
                buckets[hash] = node.next;
                size--;
                return node.value;
            }
        }
        return null;
    }

    public boolean contains(V value){
        for (MyHashNode<K,V> node: buckets) {
            while(node != null){
                if(node.value == value){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for (MyHashNode<K,V> node: buckets) {
            while(node != null){
                if(node.value == value){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "MyHashTable { " + "buckets = " + Arrays.toString(buckets) + ", size = " + size + " }";
    }
}
