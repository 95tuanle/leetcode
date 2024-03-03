import java.util.PriorityQueue;

/*
You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
You will run k sessions and hire exactly one worker in each session.
In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
A worker can only be chosen once.
Return the total cost to hire exactly k workers.
*/
public class TotalCostToHireKWorkers2462 {
    public static void main(String[] args) {
        int[] costs = {3, 2, 7, 7, 1, 2};
        int k = 2, candidates = 2;
        System.out.println(totalCost(costs, k, candidates)); // 5

        costs = new int[]{10, 10, 10, 10, 10};
        k = 5;
        candidates = 1;
        System.out.println(totalCost(costs, k, candidates)); // 50

        costs = new int[]{3, 2, 7, 7, 1, 2};
        k = 4;
        candidates = 3;
        System.out.println(totalCost(costs, k, candidates)); // 13
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftPq = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) leftPq.add(costs[i]);
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) rightPq.add(costs[i]);
        long cost = 0;
        int leftTail = candidates, rightHead = costs.length - rightPq.size() - 1;
        for (int i = 0; i < k; i++)
            if (rightPq.isEmpty() || (!leftPq.isEmpty() && (rightPq.peek() >= leftPq.peek()))) {
                cost += leftPq.poll();
                if (leftTail <= rightHead) leftPq.add(costs[leftTail++]);
            } else {
                cost += rightPq.poll();
                if (leftTail <= rightHead) rightPq.add(costs[rightHead--]);
            }
        return cost;
    }
}
