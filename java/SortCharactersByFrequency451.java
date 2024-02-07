import java.util.ArrayList;
import java.util.HashMap;

/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.
*/
public class SortCharactersByFrequency451 {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree")); // eert
        System.out.println(frequencySort("cccaaa")); // cccaaa
        System.out.println(frequencySort("Aabb")); // bbAa
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        HashMap<Integer, ArrayList<Character>> bucket = new HashMap<>();
        for (char c : frequency.keySet()) {
            if (!bucket.containsKey(frequency.get(c))) bucket.put(frequency.get(c), new ArrayList<>());
            bucket.get(frequency.get(c)).add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length(); i > 0; i--)
            if (bucket.containsKey(i)) for (char c : bucket.get(i))
                stringBuilder.append(String.valueOf(c).repeat(i));
        return stringBuilder.toString();
    }
}
