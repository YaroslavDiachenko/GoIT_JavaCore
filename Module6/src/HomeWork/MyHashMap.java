package HomeWork;


public class MyHashMap<K,V> {

    private Node<K,V>[] table;
    private int size;
    private float loadFactor = 0.75f;

    MyHashMap() {
        this.table = (Node<K,V>[])new Node[16];
    }

    void put(K key, V value) {
        int hash = hash(key);
        int i = indexFor(hash,table.length);
        Node<K,V> e = table[i];
        if (e == null) table[i] = new Node<>(hash,key,value,null);
        else {
            boolean a = checkDuplicate(key,value,e);
            if (!a) table[i] = new Node<>(hash, key, value, e);
        }
        if (++size > (int)(table.length * loadFactor))
            resize(table.length * 2);

    }
    void remove(K key) {
        int hash = hash(key);
        int i = indexFor(hash,table.length);
        Node<K,V> prev = table[i];
        Node<K,V> e = prev;
        boolean result = false;
        while (e != null) {
            Node<K,V> next = e.next;
            Object k;
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                size--;
                result = true;
                if (prev == e) table[i] = next;
                else prev.next = next;
            }
            prev = e;
            e = next;
        }
        if (!result) System.out.println("Key not found.");
    }
    void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }
    int size() {
        return size;
    }
    V get(K key) {
        int hash = hash(key);
        int i = indexFor(hash,table.length);
        Node<K,V> e = table[i];
        while (e != null) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                return e.value;
            e = e.next;
        }
        return null;
    }

    final int hash(K key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    int indexFor(int hash, int capacity) {
        return hash & (capacity - 1);
    }
    boolean checkDuplicate(K key, V value, Node<K,V> e) {
        int hash = hash(key);
        Object k;
        do {
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                e.value = value;
                return true;
            }
            e = e.next;
        }while(e != null);
        return false;
    }
    void resize(int newCapacity) {
        Node[] newTable = new Node[newCapacity];
        transfer(newTable);
        table = newTable;
    }
    void transfer(Node[] newTable) {
        Node[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Node<K,V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Node<K,V> next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                }while (e != null);
            }
        }

    }
    void show() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) System.out.print("\n" + i + ": empty;");
            else {
                System.out.print("\n" + i + ": " + table[i].key + "-" + table[i].value + "; ");
                Node<K,V> e = table[i];
                while (e.next != null) {
                    System.out.print(e.next.key + "-" + e.next.value + "; ");
                    e = e.next;
                }
            }
        }
        System.out.println("\n-----------");
    }

    private static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}