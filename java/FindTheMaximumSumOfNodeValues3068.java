import java.util.Arrays;

/*
There exists an undirected tree with n nodes numbered 0 to n - 1. You are given a 0-indexed 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the tree. You are also given a positive integer k, and a 0-indexed array of non-negative integers nums of length n, where nums[i] represents the value of the node numbered i.
Alice wants the sum of values of tree nodes to be maximum, for which Alice can perform the following operation any number of times (including zero) on the tree:
Choose any edge [u, v] connecting the nodes u and v, and update their values as follows:
nums[u] = nums[u] XOR k
nums[v] = nums[v] XOR k
Return the maximum possible sum of the values Alice can achieve by performing the operation any number of times.
*/
public class FindTheMaximumSumOfNodeValues3068 {
    public static void main(String[] args) {
        System.out.println(maximumValueSum(new int[]{1, 2, 3}, 1, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(maximumValueSum(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 2, new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7}, {0, 8}, {0, 9}}));
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        int length = nums.length;
        int[] delta = new int[length];
        long result = 0;
        for (int i = 0; i < length; i++) {
            delta[i] = (nums[i] ^ k) - nums[i];
            result += nums[i];
        }
        Arrays.sort(delta);
        for (int i = length - 1; i > 0; i--) {
            int pathDelta = delta[i] + delta[--i];
            if (pathDelta <= 0) break;
            result += pathDelta;
        }
        return result;
    }
}
