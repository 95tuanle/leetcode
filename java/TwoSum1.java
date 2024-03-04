import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/
public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        for (int i : result2) {
            System.out.print(i + " ");
        }

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        for (int i : result3) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentTarget = target - nums[i];
            if (hashMap.containsKey(currentTarget)) return new int[]{hashMap.get(currentTarget), i};
            hashMap.put(nums[i], i);
        }
        return null;

//        for (int i = 0; i < nums.length - 1; i++) {
//            int currentTarget = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) if (currentTarget == nums[j]) return new int[]{i, j};
//        }
//        return null;
    }
}
