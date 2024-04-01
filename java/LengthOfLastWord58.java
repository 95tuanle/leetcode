/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.
*/
public class LengthOfLastWord58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    public static int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != ' ') result++;
            else if (result > 0) break;
        return result;
    }
}
