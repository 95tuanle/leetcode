/*
A wonderful string is a string where at most one letter appears an odd number of times.
For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.
A substring is a contiguous sequence of characters in a string.
*/
public class NumberOfWonderfulSubstrings {
    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("aba")); // 4
        System.out.println(wonderfulSubstrings("aabb")); // 9
        System.out.println(wonderfulSubstrings("he")); // 2
    }

    public static long wonderfulSubstrings(String word) {
        long[] count = new long[1024];
        count[0] = 1;
        int mask = 0;
        long result = 0;
        for (char c : word.toCharArray()) {
            int bit = c - 'a';
            mask ^= 1 << bit;
            result += count[mask];
            count[mask]++;
            for (int i = 0; i < 10; i++) result += count[mask ^ (1 << i)];
        }
        return result;
    }
}
