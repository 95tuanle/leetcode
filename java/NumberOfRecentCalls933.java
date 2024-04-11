import java.util.LinkedList;

/*
You have a RecentCounter class which counts the number of recent requests within a certain time frame.
Implement the RecentCounter class:
RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
*/
public class NumberOfRecentCalls933 {
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}

class RecentCounter {
    final LinkedList<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        this.queue.add(t);
        while (!this.queue.isEmpty() && this.queue.peek() < t - 3000) this.queue.poll();
        return this.queue.size();
    }
}
