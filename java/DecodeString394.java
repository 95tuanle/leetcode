
import java.util.Stack;

/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
*/
public class DecodeString394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentCount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) currentCount = currentCount * 10 + (c - '0');
            else if (c == '[') {
                countStack.push(currentCount);
                stringStack.push(currentString.toString());
                currentCount = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                int count = countStack.pop();
                String previousString = stringStack.pop();
                StringBuilder temp = new StringBuilder(previousString);
                temp.append(String.valueOf(currentString).repeat(Math.max(0, count)));
                currentString = temp;
            } else currentString.append(c);
        }
        return currentString.toString();
    }
}
