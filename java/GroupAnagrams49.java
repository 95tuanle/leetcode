import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/
public class GroupAnagrams49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String string : strs) {
            char[] chars = new char[26];
            for (char c : string.toCharArray()) chars[c - 'a']++;
            String keyString = String.valueOf(chars);
            if (!hashMap.containsKey(keyString)) hashMap.put(keyString, new ArrayList<>());
            hashMap.get(keyString).add(string);
        }
        return new ArrayList<>(hashMap.values());

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
