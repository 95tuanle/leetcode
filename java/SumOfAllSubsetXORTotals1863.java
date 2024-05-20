/*
The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums.
Note: Subsets with the same elements should be counted multiple times.
An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
*/
public class SumOfAllSubsetXORTotals1863 {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

    public static int subsetXORSum(int[] nums) {
        return depthFirstSearch(0, 0, nums, nums.length);
    }

    private static int depthFirstSearch(int i, int total, int[] nums, int length) {
        if (i == length) return total;
        return depthFirstSearch(i + 1, total ^ nums[i], nums, length) + depthFirstSearch(i + 1, total, nums, length);
    }
}
