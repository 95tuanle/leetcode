import java.util.HashMap;
import java.util.Map;

/*
Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of consecutive repeating characters in chars:
If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done modifying the input array, return the new length of the array.
You must write an algorithm that uses only constant extra space.
*/
public class StringCompression443 {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(compress(new char[]{'a','a','a','b','b','a','a'}));
    }

    public static int compress(char[] chars) {
        int i = 0;
        int j = 0;
        while (j < chars.length) {
            int count = 0;
            char c = chars[j];
            while (j < chars.length && chars[j] == c) {
                count++;
                j++;
            }
            chars[i] = c;
            i++;
            if (count != 1) {
                for (char ch : Integer.toString(count).toCharArray()) {
                    chars[i] = ch;
                    i++;
                }
            }
        }
        return i;

//        Map<Character, Integer> map = new HashMap<>();
//        for (char c: chars) {
//            if (map.containsKey(c)) {
//                map.put(c, map.get(c)+1);
//            } else {
//                map.put(c,1);
//            }
//        }
//        int i = 0;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                chars[i] = entry.getKey();
//                i++;
//            } else {
//                chars[i] = entry.getKey();
//                for (int j = 0; j < entry.getValue().toString().length(); j++) {
//                    chars[i+1+j] = entry.getValue().toString().charAt(j);
//                }
//                i = i + 1 + entry.getValue().toString().length();
//            }
//        }
//        for (int j = i; j < chars.length; j++) {
//            chars[j] = ' ';
//        }
//        return i;
    }
}
