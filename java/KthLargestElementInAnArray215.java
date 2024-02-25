/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?
*/
public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(findKthLargest(nums2, k2));

        int[] nums3 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k3 = 4;
        System.out.println(findKthLargest(nums3, k3));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);

//        Arrays.sort(nums);
//        return nums[nums.length - k];
    }

    private static int quickSelect(int[] nums, int left, int right, int target) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++)
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        swap(nums, i, right);
        if (i == target) return nums[i];
        else if (i < target) return quickSelect(nums, i + 1, right, target);
        else return quickSelect(nums, left, i - 1, target);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
