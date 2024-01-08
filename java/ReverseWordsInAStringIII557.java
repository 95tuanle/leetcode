
/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/
public class ReverseWordsInAStringIII557 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("God Ding"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) stringBuilder.append(reverseWord(word)).append(" ");
        return stringBuilder.toString().trim();
    }

    private static char[] reverseWord(String word) {
        char[] chars = word.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
            i++;
            j--;
        }
        return chars;
    }
}