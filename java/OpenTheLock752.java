import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
The lock initially starts at '0000', a string representing the state of the 4 wheels.
You are given a list of deadgends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
*/
public class OpenTheLock752 {
    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202")); // 6
        System.out.println(openLock(new String[]{"8888"}, "0009")); // 1
        System.out.println(openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888")); // -1
        System.out.println(openLock(new String[]{"0000"}, "8888")); // -1
    }

    public static int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        LinkedList<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int breathSize = queue.size();
            for (int i = 0; i < breathSize; i++) {
                String combination = queue.remove();
                if (combination.equals(target)) return depth;
                char[] chars = combination.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char originalChar = chars[j];
                    for (int k = -1; k <= 1; k += 2) {
                        chars[j] = (char) ((originalChar - '0' + k + 10) % 10 + '0');
                        String newCombination = new String(chars);
                        if (!visited.contains(newCombination)) {
                            visited.add(newCombination);
                            queue.add(newCombination);
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            depth++;
        }
        return -1;
    }
}
