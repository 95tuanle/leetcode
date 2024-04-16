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
        for (char c : s.toCharArray()) {
            int lastCharIndex = stringBuilder.length() - 1;
            if (lastCharIndex >= 0 && Math.abs(stringBuilder.charAt(lastCharIndex) - c) == 32)
                stringBuilder.deleteCharAt(lastCharIndex);
            else stringBuilder.append(c);
        }
        return stringBuilder.toString();

//        ArrayDeque<Character> stack = new ArrayDeque<>();
//        for (int i = 0; i < s.length(); i++)
//            if (!stack.isEmpty() && Math.abs(stack.peekLast() - s.charAt(i)) == 32) stack.removeLast();
//            else stack.addLast(s.charAt(i));
//        StringBuilder stringBuilder = new StringBuilder();
//        while (!stack.isEmpty()) stringBuilder.append(stack.removeLast());
//        return stringBuilder.reverse().toString();
    }
}
