/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*/
public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(majorityElement(nums));

        int[] nums2 = {3, 2, 3};
        System.out.println(majorityElement(nums2));

        int[] nums3 = {1};
        System.out.println(majorityElement(nums3));
    }

    public static int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) count++;
            else count--;
        }
        return major;

//        int candidate = 0;
//        int count = 0;
//        for (int num : nums)
//            if (count == 0) {
//                candidate = num;
//                count = 1;
//            } else if (num == candidate) count++;
//            else count--;
//        return candidate;
    }
}
