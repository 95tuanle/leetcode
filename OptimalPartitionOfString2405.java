/*
Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
Return the minimum number of substrings in such a partition.
Note that each character should belong to exactly one substring in a partition.
*/
import java.util.ArrayList;

public class OptimalPartitionOfString2405 {
    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
        System.out.println(partitionString("ssssss"));
    }

    public static int partitionString(String s) {
        ArrayList<String> substrings = new ArrayList<>();
        StringBuilder substring = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!substring.toString().contains(String.valueOf(s.charAt(i)))) {
                substring.append(s.charAt(i));
            } else {
                substrings.add(substring.toString());
                substring = new StringBuilder();
                substring.append(s.charAt(i));
            }
        }
        substrings.add(substring.toString());
        return substrings.size();
    }
}
