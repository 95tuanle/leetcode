import java.util.HashSet;
import java.util.List;

/*
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
Return the maximum possible length of s.
A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
*/
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239 {
    public static void main(String[] args) {
        System.out.println(maxLength(List.of("un", "iq", "ue")));
        System.out.println(maxLength(List.of("cha", "r", "act", "ers")));
        System.out.println(maxLength(List.of("abcdefghijklmnopqrstuvwxyz")));
    }

    public static int maxLength(List<String> arr) {
        return backtracking(arr, 0, new HashSet<>());
    }

    private static int backtracking(List<String> arr, int i, HashSet<Character> cur) {
        if (i == arr.size()) return cur.size();
        String string = arr.get(i);
        if (string.length() != string.chars().distinct().count()) return backtracking(arr, i + 1, cur);
        char[] chars = string.toCharArray();
        boolean isOverlapping = false;
        for (char c : chars)
            if (cur.contains(c)) {
                isOverlapping = true;
                break;
            }
        int res = 0;
        if (!isOverlapping) {
            for (char c : chars) cur.add(c);
            res = backtracking(arr, i + 1, cur);
            for (char c : chars) cur.remove(c);
        }
        return Math.max(res, backtracking(arr, i + 1, cur));
    }
}
