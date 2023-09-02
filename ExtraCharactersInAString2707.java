import java.util.Arrays;
import java.util.HashSet;

/*
You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.
Return the minimum number of extra characters left over if you break up s optimally.
*/
public class ExtraCharactersInAString2707 {
    public static void main(String[] args) {
        System.out.println(minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
        System.out.println(minExtraChar("sayhelloworld", new String[]{"hello", "world"}));
        System.out.println(minExtraChar("dwmodizxvvbosxxw", new String[]{"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"}));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[n + 1];
        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            for (int end = start; end < n; end++) {
                var curr = s.substring(start, end + 1);
                if (dictionarySet.contains(curr)) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }
        return dp[0];
//        StringBuilder substring = new StringBuilder();
//        int previousEnd = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (String string : dictionary) {
//                if (string.length() <= i + 1 - previousEnd && string.equals(s.substring(i + 1 - string.length(), i + 1))) {
//                    substring.append(string);
//                    previousEnd = i+1;
//                    break;
//                }
//            }
//        }
//        return s.length() - substring.length();
    }
}
