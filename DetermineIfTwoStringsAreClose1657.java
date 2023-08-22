import java.util.Arrays;

/*
Two strings are considered close if you can attain one from the other using the following operations:
Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.
Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
*/
public class DetermineIfTwoStringsAreClose1657 {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings("cabbba", "aabbss"));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            System.out.println(c - 'a');
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] > 0) || (freq1[i] > 0 && freq2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);

//        if (word1.length() == word2.length()) {
//            Map<Character, Integer> dict1 = new HashMap<>();
//            Map<Character, Integer> dict2 = new HashMap<>();
//            for (int i = 0; i < word1.length(); i++) {
//                dict1.put(word1.charAt(i), dict1.getOrDefault(word1.charAt(i), 0) + 1);
//                dict2.put(word2.charAt(i), dict2.getOrDefault(word2.charAt(i), 0) + 1);
//            }
//            if (dict1.keySet().equals(dict2.keySet())) {
//                List<Integer> list1 = new ArrayList<>(dict1.values());
//                List<Integer> list2 = new ArrayList<>(dict2.values());
//                Collections.sort(list1);
//                Collections.sort(list2);
//                return list1.equals(list2);
//            }
//        }
//        return false;
    }
}
