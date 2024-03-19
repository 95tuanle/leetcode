import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
Return the minimum number of intervals required to complete all tasks.
*/
public class TaskScheduler621 {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0)); // 6
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2)); // 16
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) freq[task - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : freq) if (i > 0) pq.offer(i);
        int time = 0;
        LinkedList<int[]> ll = new LinkedList<>();
        while (!pq.isEmpty() || !ll.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int count = pq.poll() - 1;
                if (count > 0) ll.offer(new int[]{count, time + n});
            }
            if (!ll.isEmpty() && ll.peek()[1] == time) pq.offer(ll.poll()[0]);
        }
        return time;
    }
}
