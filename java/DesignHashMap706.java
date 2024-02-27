import java.util.Arrays;

/*
Design a HashMap without using any built-in hash table libraries.
Implement the MyHashMap class:
MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
*/
public class DesignHashMap706 {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 123);
        int param_2 = obj.get(1);
        System.out.println(param_2);
        obj.remove(1);
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}

class MyHashMap {
    final int[] data;

    public MyHashMap() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }
}

//class MyHashMap {
//    private static final int CAPACITY = 1000001;
//
//    private final List<Entry>[] table;
//
//    public MyHashMap() {
//        table = new ArrayList[CAPACITY];
//        for (int i = 0; i < CAPACITY; i++) {
//            table[i] = new ArrayList<>();
//        }
//    }
//
//    public void put(int key, int value) {
//        int index = key % CAPACITY;
//        for (Entry entry : table[index]) {
//            if (entry.key == key) {
//                entry.value = value;
//                return;
//            }
//        }
//        table[index].add(new Entry(key, value));
//    }
//
//    public int get(int key) {
//        int index = key % CAPACITY;
//        for (Entry entry : table[index]) {
//            if (entry.key == key) {
//                return entry.value;
//            }
//        }
//        return -1;
//    }
//
//    public void remove(int key) {
//        int index = key % CAPACITY;
//        Iterator<Entry> iterator = table[index].iterator();
//        while (iterator.hasNext()) {
//            Entry entry = iterator.next();
//            if (entry.key == key) {
//                iterator.remove();
//                return;
//            }
//        }
//    }
//
//    private static class Entry {
//        int key;
//        int value;
//
//        public Entry(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//}

//class MyHashMap<K, V> {
//    private static final int DEFAULT_CAPACITY = 16;
//    private static final double LOAD_FACTOR = 0.75;
//
//    private LinkedList<Entry<K, V>>[] buckets;
//    private int size;
//
//    public MyHashMap() {
//        buckets = new LinkedList[DEFAULT_CAPACITY];
//        size = 0;
//    }
//
//    public void put(K key, V value) {
//        if (key == null)
//            return;
//
//        int index = hash(key);
//        if (buckets[index] == null) {
//            buckets[index] = new LinkedList<>();
//        }
//
//        for (Entry<K, V> entry : buckets[index]) {
//            if (entry.key.equals(key)) {
//                entry.value = value;
//                return;
//            }
//        }
//
//        buckets[index].add(new Entry<>(key, value));
//        size++;
//
//        if ((double) size / buckets.length >= LOAD_FACTOR) {
//            resize();
//        }
//    }
//
//    public int get(K key) {
//        if (key == null)
//            return -1;
//
//        int index = hash(key);
//        if (buckets[index] == null)
//            return -1;
//
//        for (Entry<K, V> entry : buckets[index]) {
//            if (entry.key.equals(key)) {
//                return (int) entry.value;
//            }
//        }
//
//        return -1;
//    }
//
//    public void remove(K key) {
//        if (key == null)
//            return;
//
//        int index = hash(key);
//        if (buckets[index] == null)
//            return;
//
//        buckets[index].removeIf(entry -> entry.key.equals(key));
//    }
//
//    private int hash(K key) {
//        return key.hashCode() % buckets.length;
//    }
//
//    private void resize() {
//        int newCapacity = buckets.length * 2;
//        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[newCapacity];
//
//        for (LinkedList<Entry<K, V>> bucket : buckets) {
//            if (bucket != null) {
//                for (Entry<K, V> entry : bucket) {
//                    int index = entry.key.hashCode() % newCapacity;
//                    if (newBuckets[index] == null) {
//                        newBuckets[index] = new LinkedList<>();
//                    }
//                    newBuckets[index].add(entry);
//                }
//            }
//        }
//
//        buckets = newBuckets;
//    }
//
//    private static class Entry<K, V> {
//        K key;
//        V value;
//
//        Entry(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//}