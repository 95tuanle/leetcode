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
        int[] result = new int[1];
        dfs(arr, 0, "", result);
        return result[0];
    }

    private static void dfs(List<String> arr, int index, String current, int[] result) {
        if (index == arr.size() && unique(current)) {
            result[0] = Math.max(result[0], current.length());
            return;
        }
        if (index == arr.size()) return;
        dfs(arr, index + 1, current, result);
        dfs(arr, index + 1, current + arr.get(index), result);
    }

    private static boolean unique(String current) {
        int[] count = new int[26];
        for (char c : current.toCharArray())
            if (count[c - 'a']++ > 0) return false;
        return true;
    }
}
