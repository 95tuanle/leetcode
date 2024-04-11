/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
*/
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();

        int[] nums2 = {2, 0, 1};
        sortColors(nums2);
        for (int num : nums2)
            System.out.print(num + " ");
        System.out.println();

        int[] nums3 = {0};
        sortColors(nums3);
        for (int num : nums3)
            System.out.print(num + " ");
    }

    public static void sortColors(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
    }
}
