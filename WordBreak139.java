/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/

import java.util.List;

public class WordBreak139 {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        return false;

//        boolean[] dp = new boolean[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            for (String word : wordDict) {
//                if (word.length() <= i + 1 && word.equals(s.substring(i + 1 - word.length(), i + 1))) {
//                    if (i + 1 - word.length() == 0 || dp[i - word.length()]) {
//                        dp[i] = true;
//                        break;
//                    }
//                }
//            }
//        }
//        return dp[s.length() - 1];
    }
}
