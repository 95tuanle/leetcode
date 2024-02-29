import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.
For chosen indices i0, i1, ..., ik - 1, your score is defined as:
The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
Return the maximum possible score.
A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.
*/
public class MaximumSubsequenceScore2542 {
    public static void main(String[] args) {
//        Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
//        Output: 12
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k));

//        Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
//        Output: 30
        int[] nums3 = {4, 2, 3, 1, 1};
        int[] nums4 = {7, 5, 10, 9, 6};
        int k1 = 1;
        System.out.println(maxScore(nums3, nums4, k1));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) pairs[i] = new int[]{nums2[i], nums1[i]};
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        long res = 0, sumS = 0;
        for (int[] es : pairs) {
            pq.add(es[1]);
            sumS = (sumS + es[1]);
            if (pq.size() > k) sumS -= pq.poll();
            if (pq.size() == k) res = Math.max(res, (sumS * es[0]));
        }
        return res;
    }
}
