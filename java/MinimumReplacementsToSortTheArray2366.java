
/*
You are given a 0-indexed integer array nums. In one operation you can replace any element of the array with any two elements that sum to it.
For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].
Return the minimum number of operations to make an array that is sorted in non-decreasing order.
*/
public class MinimumReplacementsToSortTheArray2366 {
    public static void main(String[] args) {
        System.out.println(minimumReplacement(new int[]{3, 9, 3}));
        System.out.println(minimumReplacement(new int[]{5, 6, 7}));
        System.out.println(minimumReplacement(new int[]{1, 2, 3, 4, 5}));
    }

    public static long minimumReplacement(int[] nums) {
        long times = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) continue;
            long numberOfElements = (nums[i] + nums[i + 1] - 1) / nums[i + 1];
            times += numberOfElements - 1;
            nums[i] = (int) (nums[i] / numberOfElements);
        }
        return times;
    }
}
