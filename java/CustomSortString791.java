/*
You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
Return any permutation of s that satisfies this property.
*/
public class CustomSortString791 {
    public static void main(String[] args) {
        String order1 = "cba";
        String s1 = "abcd";
        System.out.println(customSortString(order1, s1));

        String order2 = "cbafg";
        String s2 = "abcd";
        System.out.println(customSortString(order2, s2));
    }

    public static String customSortString(String order, String s) {
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) frequencies[c - 'a']++;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : order.toCharArray())
            if (frequencies[c - 'a'] > 0) {
                stringBuilder.append(String.valueOf(c).repeat(frequencies[c - 'a']));
                frequencies[c - 'a'] = 0;
            }
        for (int i = 0; i < frequencies.length; i++)
            if (frequencies[i] > 0) stringBuilder.append(String.valueOf((char) ('a' + i)).repeat(frequencies[i]));
        return stringBuilder.toString();
    }
}
