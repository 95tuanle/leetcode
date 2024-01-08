/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*/
public class IsSubsequence392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("", "ahbgdc"));
        System.out.println(isSubsequence("abc", "abc"));
        System.out.println(isSubsequence("abc", "ab"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        else if (s.length() == t.length()) return s.equals(t);
        int position = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(position) == t.charAt(i)) position++;
            if (position == s.length()) return true;
        }
        return false;

//        int i = 0, j = 0;
//        while (i < s.length() && j < t.length()) {
//            if (s.charAt(i) == t.charAt(j)) {
//                i++;
//            }
//            j++;
//        }
//        return i == s.length();
    }
}
