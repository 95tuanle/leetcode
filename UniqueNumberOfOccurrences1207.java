import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
*/
public class UniqueNumberOfOccurrences1207 {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueOccurrences(new int[]{1, 2}));
        System.out.println(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Set<Integer> freqSet = new HashSet<>(freq.values());
        return freq.size() == freqSet.size();

//        HashMap<Integer, Integer> dict = new HashMap<>();
//        for (int num : arr) {
//            if (dict.containsKey(num)) {
//                dict.replace(num, dict.get(num) + 1);
//            } else {
//                dict.put(num, 1);
//            }
//        }
//        HashMap<Integer, Integer> newDict = new HashMap<>();
//        for (int num : dict.values()) {
//            if (newDict.containsKey(num)) {
//                return false;
//            } else {
//                newDict.put(num, 1);
//            }
//        }
//        return true;
    }
}
