/*
You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:
t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
Return the length of the longest ideal string.
A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
*/
public class LongestIdealSubsequence2370 {
    public static void main(String[] args) {
        System.out.println(longestIdealString("abc", 0)); // 1
        System.out.println(longestIdealString("abc", 1)); // 2
        System.out.println(longestIdealString("abc", 2)); // 3
        System.out.println(longestIdealString("abc", 3)); // 3
        System.out.println(longestIdealString("abc", 4)); // 3
        System.out.println(longestIdealString("abc", 5)); // 3
        System.out.println(longestIdealString("abc", 6)); // 3
        System.out.println(longestIdealString("abc", 7)); // 3
        System.out.println(longestIdealString("abc", 8)); // 3
        System.out.println(longestIdealString("abc", 9)); // 3
        System.out.println(longestIdealString("abc", 10)); // 3
        System.out.println(longestIdealString("abc", 11)); // 3
        System.out.println(longestIdealString("abc", 12)); // 3
        System.out.println(longestIdealString("abc", 13)); // 3
        System.out.println(longestIdealString("abc", 14)); // 3
        System.out.println(longestIdealString("abc", 15)); // 3
        System.out.println(longestIdealString("abc", 16)); // 3
        System.out.println(longestIdealString("abc", 17)); // 3
        System.out.println(longestIdealString("abc", 18)); // 3
        System.out.println(longestIdealString("abc", 19)); // 3
        System.out.println(longestIdealString("abc", 20)); // 3
        System.out.println(longestIdealString("abc", 21)); // 3
        System.out.println(longestIdealString("abc", 22)); // 3
        System.out.println(longestIdealString("abc", 23)); // 3
        System.out.println(longestIdealString("abc", 24)); // 3
        System.out.println(longestIdealString("abc", 25)); // 3
        System.out.println(longestIdealString("abc", 26)); // 3
        System.out.println(longestIdealString("abc", 27)); // 3
    }

    public static int longestIdealString(String s, int k) {
        int result = 0;
        int[] dp = new int[26];
        for (Character character : s.toCharArray()) {
            int current = character - 'a', longest = 0;
            for (int i = Math.max(0, current - k); i <= Math.min(25, current + k); i++)
                longest = Math.max(longest, dp[i]);
            dp[current] = ++longest;
            result = Math.max(result, longest);
        }
        return result;
    }
}
