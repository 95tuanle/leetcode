/*
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseVowelsOfAString345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        char[] chars = s.toCharArray();
        List<Character> foundVowels = new ArrayList<>();
        List<Integer> foundVowelsIndex = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(Character.toLowerCase(chars[i]))) {
                foundVowels.add(chars[i]);
                foundVowelsIndex.add(i);
            }
        }
        Collections.reverse(foundVowels);
        for (int i = 0; i < foundVowelsIndex.size(); i++) {
            chars[foundVowelsIndex.get(i)] = foundVowels.get(i);
        }
        return new String(chars);
    }
}
