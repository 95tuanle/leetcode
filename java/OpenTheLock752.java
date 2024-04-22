import java.util.*;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
The lock initially starts at '0000', a string representing the state of the 4 wheels.
You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
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
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(deadends));
        if (hashSet.contains("0000")) return -1;
        hashSet.add("0000");
        Map<Character, Character> nextSlot = new HashMap<>();
        nextSlot.put('0', '1');
        nextSlot.put('1', '2');
        nextSlot.put('2', '3');
        nextSlot.put('3', '4');
        nextSlot.put('4', '5');
        nextSlot.put('5', '6');
        nextSlot.put('6', '7');
        nextSlot.put('7', '8');
        nextSlot.put('8', '9');
        nextSlot.put('9', '0');
        Map<Character, Character> prevSlot = new HashMap<>();
        prevSlot.put('0', '9');
        prevSlot.put('1', '0');
        prevSlot.put('2', '1');
        prevSlot.put('3', '2');
        prevSlot.put('4', '3');
        prevSlot.put('5', '4');
        prevSlot.put('6', '5');
        prevSlot.put('7', '6');
        prevSlot.put('8', '7');
        prevSlot.put('9', '8');
        int result = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.add("0000");
        while (!queue.isEmpty()) {
            int breathNodesCount = queue.size();
            for (int i = 0; i < breathNodesCount; i++) {
                String combination = queue.remove();
                if (combination.equals(target)) return result;
                for (int j = 0; j < 4; j++) {
                    StringBuilder stringBuilder = new StringBuilder(combination);
                    stringBuilder.setCharAt(j, nextSlot.get(stringBuilder.charAt(j)));
                    String string = stringBuilder.toString();
                    if (!hashSet.contains(string)) {
                        queue.add(string);
                        hashSet.add(string);
                    }
                    stringBuilder = new StringBuilder(combination);
                    stringBuilder.setCharAt(j, prevSlot.get(stringBuilder.charAt(j)));
                    string = stringBuilder.toString();
                    if (!hashSet.contains(string)) {
                        queue.add(string);
                        hashSet.add(string);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
