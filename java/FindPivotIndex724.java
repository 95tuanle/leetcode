
/*
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.
*/
public class FindPivotIndex724 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pivotIndex(new int[]{2, 1, -1}));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;

//        for (int i = 0; i < nums.length; i++) {
//            int left = 0, right = 0;
//            if (i > 0) {
//                for (int j = 0; j < i; j++) {
//                    left += nums[j];
//                }
//            }
//            if (i < nums.length - 1) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    right += nums[j];
//                }
//            }
//            if (left == right) return i;
//        }
//        return -1;
    }
}
