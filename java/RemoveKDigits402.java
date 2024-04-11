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
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peekLast() > c && k > 0) {
                k--;
                stack.removeLast();
            }
            stack.addLast(c);
        }
        while (!stack.isEmpty() && k > 0) {
            k--;
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.removeFirst());
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        if (sb.isEmpty()) return "0";
        return sb.toString();
    }
}
