import java.util.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
*/
public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));  // [3, 4]
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));  // [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));  // [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));  // [0, 0]
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = binarySearch(nums, target, true);
        if (left != -1) {
            int right = binarySearch(nums, target, false);
            result[0] = left;
            result[1] = right;
        }
        return result;
    }

    private static int binarySearch(int[] nums, int target, boolean searchLeft) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (searchLeft && nums[mid] == target)) right = mid - 1;
            else left = mid + 1;
            if (nums[mid] == target) result = mid;
        }
        return result;
    }

//    public static int[] searchRange(int[] nums, int target) {
//        int[] result = new int[]{-1, -1};
//        for (int i = 0; i < nums.length; i++)
//            if (nums[i] == target) {
//                result[0] = i;
//                break;
//            }
//        if (result[0] == -1) return result;
//        for (int i = nums.length - 1; i >= 0; i--)
//            if (nums[i] == target) {
//                result[1] = i;
//                break;
//            }
//        return result;
//    }
}
