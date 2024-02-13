/*
Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
A string is palindromic if it reads the same forward and backward.
*/
public class FindFirstPalindromicStringInTheArray2108 {
    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(firstPalindrome(words));

        String[] words2 = {"a", "b", "c"};
        System.out.println(firstPalindrome(words2));
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            int first = 0, last = word.length() - 1;
            while (first < last) if (word.charAt(first) == word.charAt(last)) {
                first++;
                last--;
            } else break;
            if (first >= last) return word;
        }
        return "";
    }
}
