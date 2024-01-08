package java;

/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
Return the merged string.
*/
public class MergeStringsAlternately1768 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int loop = Math.min(word1.length(), word2.length());
        StringBuilder merged = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }
        if (word1.length() > word2.length()) merged.append(word1.substring(loop));
        else if (word2.length() > word1.length()) merged.append(word2.substring(loop));
        return merged.toString();
    }
}
