import java.util.Set;

/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
*/
public class MaximumNumberOfVowelsInASubstringOfGivenLength1456 {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(maxVowels("rhythms", 4));
    }

    public static int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int temp = 0;
        for (int i = 0; i < k; i++) if (vowels.contains(s.charAt(i))) temp++;
        int max = temp;
        for (int i = k; i < s.length(); i++) {
            temp += vowels.contains(s.charAt(i)) ? 1 : 0;
            temp -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
            max = Math.max(max, temp);
        }
        return max;
    }
}
