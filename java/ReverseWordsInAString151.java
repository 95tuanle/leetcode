package java;

/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
*/
public class ReverseWordsInAString151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();

//        StringBuilder sb = new StringBuilder();
//        List<String> words = new ArrayList<>(List.of(s.split(" ")));
//        words.removeIf(String::isEmpty);
//        for (int i = words.size() - 1; i >= 0; i--) {
//            sb.append(words.get(i));
//            if (i > 0) {
//                sb.append(" ");
//            }
//        }
//        return sb.toString();
    }
}
