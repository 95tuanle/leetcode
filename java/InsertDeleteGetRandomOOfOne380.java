import java.util.*;

/*
Implement the RandomizedSet class:
RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
*/
public class InsertDeleteGetRandomOOfOne380 {
    public static void main(String[] args) {
        RandomizedSet obj2 = new RandomizedSet();
        System.out.println(obj2.insert(1));
        System.out.println(obj2.remove(2));
        System.out.println(obj2.insert(2));
        System.out.println(obj2.getRandom());
        System.out.println(obj2.remove(1));
        System.out.println(obj2.insert(2));
        System.out.println(obj2.getRandom());
    }
}

class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int lastElement = list.getLast();
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);
        list.removeLast();
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

//    HashSet<Integer> set;
//
//    public RandomizedSet() {
//        set = new HashSet<>();
//    }
//
//    public boolean insert(int val) {
//        if (set.contains(val)) return false;
//        set.add(val);
//        return true;
//    }
//
//    public boolean remove(int val) {
//        if (set.contains(val)) {
//            set.remove(val);
//            return true;
//        }
//        return false;
//    }
//
//    public int getRandom() {
//        if (!set.isEmpty()) return (int) set.toArray()[(int) (Math.random() * set.size())];
//        return Integer.MAX_VALUE;
//    }
}