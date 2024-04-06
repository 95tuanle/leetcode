/*
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
*/
public class MinimumRemoveToMakeValidParentheses1249 {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));

        s = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s));

        s = "))((";
        System.out.println(minRemoveToMakeValid(s));

        s = "(a(b(c)d)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray())
            if (c == '(') {
                stringBuilder.append(c);
                count++;
            } else if (c == ')' && count > 0) {
                stringBuilder.append(c);
                count--;
            } else if (c != ')') stringBuilder.append(c);
        for (int i = stringBuilder.length() - 1; i >= 0; i--)
            if (stringBuilder.charAt(i) == '(' && count > 0) {
                stringBuilder.deleteCharAt(i);
                count--;
            }
        return stringBuilder.toString();
    }
}
