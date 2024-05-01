/*
Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
Return the resulting string.
*/
public class ReversePrefixOfWord2000 {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd')); // dcbaefd
        System.out.println(reversePrefix("xyxzxe", 'z')); // zyxzxe
        System.out.println(reversePrefix("abcd", 'z')); // abcd
    }

    public static String reversePrefix(String word, char ch) {
        char[] result = word.toCharArray();
        int left = 0, right = 0;
        for (char c : result) {
            if (c == ch) {
                while (left < right) {
                    char rightChar = result[right];
                    result[right--] = result[left];
                    result[left++] = rightChar;
                }
                return new String(result);
            }
            right++;
        }
        return word;
    }
}
