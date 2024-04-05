/*
Given a string s of lower and upper case English letters.
A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
Notice that an empty string is also good.
*/
public class MakeTheStringGreat1544 {
    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));

        s = "abBAcC";
        System.out.println(makeGood(s));

        s = "s";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (!stringBuilder.isEmpty() && Math.abs(stringBuilder.charAt(stringBuilder.length() - 1) - s.charAt(i)) == 32)
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            else stringBuilder.append(s.charAt(i));
        return stringBuilder.toString();

//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++)
//            if (!stack.empty() && Math.abs(stack.peek() - s.charAt(i)) == 32) stack.pop();
//            else stack.push(s.charAt(i));
//        StringBuilder stringBuilder = new StringBuilder();
//        while (!stack.empty()) stringBuilder.append(stack.pop());
//        return stringBuilder.reverse().toString();
    }
}
