import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/
public class GroupAnagrams49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
//        Map<String, int[]> map = new HashMap<>();
//        for (String str : strs) {
//            if (map.containsKey(str)) {
//                continue;
//            }
//            int[] count = new int[26];
//            for (char c : str.toCharArray()) {
//                count[c - 'a']++;
//            }
//            map.put(str, count);
//        }
//        List<List<String>> result = new ArrayList<>();
//        for (String str : strs) {
//            int[] count = map.get(str);
//            boolean found = false;
//            for (List<String> list : result) {
//                int[] count2 = map.get(list.get(0));
//                if (Arrays.equals(count, count2)) {
//                    list.add(str);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                result.add(list);
//            }
//        }
//        return result;
    }
}
