/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
*/
public class MoveZeroes283 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{0});
        moveZeroes(new int[]{0, 0, 1});
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int num : nums)
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        if (i == 0) return;
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }

//        int[] newNums = new int[nums.length];
//        int first = 0;
//        int second = nums.length-1;
//        for (int anInt: nums) {
//            if (anInt == 0) {
//                newNums[second] = 0;
//                second--;
//            } else {
//                newNums[first] = anInt;
//                first++;
//            }
//        }
//        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }
}
