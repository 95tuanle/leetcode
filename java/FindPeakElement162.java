/*
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.
*/
public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));

        int[] nums1 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findPeakElement(nums2));

        int[] nums3 = {1, 2, 3};
        System.out.println(findPeakElement(nums3));
    }

    public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) start = mid + 1;
            else end = mid;
        }
        return start;

//        int n = nums.length;
//        if (n == 1) return 0;
//        else {
//            int slow = -1, mid = 0, fast = 1;
//            do
//                if (((slow == -1) && (nums[mid] > nums[fast])) || ((fast == n) && (nums[mid] > nums[slow])) || ((slow > -1) && (fast < n) && (nums[mid] > nums[slow]) && (nums[mid] > nums[fast])))
//                    return mid;
//                else {
//                    slow++;
//                    mid++;
//                    fast++;
//                } while (fast <= n);
//        }
//        return -1;
    }
}
