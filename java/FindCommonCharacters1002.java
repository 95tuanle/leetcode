import java.util.ArrayList;
import java.util.List;

/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
*/
public class FindCommonCharacters1002 {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        System.out.println(commonChars(words));

        String[] words2 = {"cool", "lock", "cook"};
        System.out.println(commonChars(words2));

        String[] words3 = {"bella", "label", "roller"};
        System.out.println(commonChars(words3));
    }

    public static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] commonCharacterCounts = new int[26];
        for (char c : words[0].toCharArray()) commonCharacterCounts[c - 'a']++;
        for (int i = 1; i < words.length; i++) {
            int[] currentCharacterCounts = new int[26];
            for (char c : words[i].toCharArray()) currentCharacterCounts[c - 'a']++;
            for (int j = 0; j < 26; j++)
                commonCharacterCounts[j] = Math.min(commonCharacterCounts[j], currentCharacterCounts[j]);
        }
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < commonCharacterCounts[i]; j++) result.add(Character.toString(i + 'a'));
        return result;
    }
}
