/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
*/
public class FirstUniqueCharacterInAString387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode")); // 0
        System.out.println(firstUniqChar("loveleetcode")); // 2
        System.out.println(firstUniqChar("aabb")); // -1
    }

    public static int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) result = Math.min(result, index);
        }
        return result == Integer.MAX_VALUE ? -1 : result;

//        HashMap<Character, Integer> counter = new HashMap<>();
//        for (char c : s.toCharArray()) counter.put(c, counter.getOrDefault(c, 0) + 1);
//        for (int i = 0; i < s.length(); i++)
//            if (counter.get(s.charAt(i)) == 1) return i;
//        return -1;
    }
}
