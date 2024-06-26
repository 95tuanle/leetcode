/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
The following rules define a valid string:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
*/
public class ValidParenthesisString678 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(checkValidString(s));

        s = "(*)";
        System.out.println(checkValidString(s));

        s = "(*))";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        int openBalance = 0, closeBalance = 0, length = s.length() - 1;
        for (int i = 0; i <= length; i++) {
            if (s.charAt(i) == ')') openBalance--;
            else openBalance++;
            if (s.charAt(length - i) == '(') closeBalance--;
            else closeBalance++;
            if (openBalance < 0 || closeBalance < 0) return false;
        }
        return true;
    }
}
