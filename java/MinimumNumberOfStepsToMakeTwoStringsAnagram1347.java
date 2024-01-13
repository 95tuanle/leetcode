/*
You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
*/
public class MinimumNumberOfStepsToMakeTwoStringsAnagram1347 {
    public static void main(String[] args) {
        System.out.println(minSteps("bab", "aba"));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(minSteps("anagram", "mangaar"));
        System.out.println(minSteps("xxyyzz", "xxyyzz"));
        System.out.println(minSteps("friend", "family"));
    }

    public static int minSteps(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;
        int result = 0;
        for (int i : count) if (i > 0) result += i;
        return result;
    }
}
