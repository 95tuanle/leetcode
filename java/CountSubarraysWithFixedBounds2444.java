/*
You are given an integer array nums and two integers minK and maxK.
A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.
A subarray is a contiguous part of an array.
*/
public class CountSubarraysWithFixedBounds2444 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 2, 1, 2, 3}, 2, 3));
        System.out.println(countSubarrays(new int[]{1, 2, 1, 3, 4}, 2, 3));
        System.out.println(countSubarrays(new int[]{2, 2, 2, 1, 1}, 1, 2));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int invalidIndex = -1, minIndex = -1, maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) invalidIndex = i;
            if (nums[i] == minK) minIndex = i;
            if (nums[i] == maxK) maxIndex = i;
            result += Math.max(0, Math.min(minIndex, maxIndex) - invalidIndex);
        }
        return result;
    }
}
