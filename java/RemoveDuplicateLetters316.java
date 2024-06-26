import java.util.ArrayDeque;

/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
the smallest in lexicographical order among all possible results.
*/
public class RemoveDuplicateLetters316 {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public static String removeDuplicateLetters(String s) {
        int[] charCount = new int[26];
        for (char character : s.toCharArray()) charCount[character - 'a']++;
        boolean[] visited = new boolean[26];
        ArrayDeque<Character> characters = new ArrayDeque<>();
        for (char character : s.toCharArray()) {
            charCount[character - 'a']--;
            if (visited[character - 'a']) continue;
            while (!characters.isEmpty() && character < characters.peekLast() && charCount[characters.peekLast() - 'a'] > 0)
                visited[characters.removeLast() - 'a'] = false;
            characters.addLast(character);
            visited[character - 'a'] = true;
        }
        StringBuilder result = new StringBuilder();
        for (char character : characters) result.append(character);
        return result.toString();
    }
}
