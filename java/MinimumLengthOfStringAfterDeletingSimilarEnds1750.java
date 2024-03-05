/*
Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).
*/
public class MinimumLengthOfStringAfterDeletingSimilarEnds1750 {
    public static void main(String[] args) {
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
        System.out.println(minimumLength("abccba"));
    }

    public static int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) break;
            left++;
            right--;
            while (s.charAt(left) == leftChar && left <= right) left++;
            while (s.charAt(right) == rightChar && left <= right) right--;
        }
        return right - left + 1;
    }

}
