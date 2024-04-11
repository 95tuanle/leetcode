import java.util.LinkedList;

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
        LinkedList<Character> deque = new LinkedList<>();
        for (char digit : num.toCharArray()) {
            while (!deque.isEmpty() && deque.peekLast() > digit && k > 0) {
                k--;
                deque.removeLast();
            }
            deque.addLast(digit);
        }
        while (k-- > 0) deque.removeLast();
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : deque) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
