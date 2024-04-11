import java.util.ArrayDeque;

/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
*/
public class RemoveKDigits402 {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
        System.out.println(removeKdigits("9", 1));
    }

    public static String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peekLast() > digit && k > 0) {
                k--;
                stack.removeLast();
            }
            stack.addLast(digit);
        }
        while (k-- > 0) stack.removeLast();
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
