import java.util.HashMap;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.
*/
public class BinarySubarraysWithSum930 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));

        int[] nums2 = {0, 0, 0, 0, 0};
        int goal2 = 0;
        System.out.println(numSubarraysWithSum(nums2, goal2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0, sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (sum == goal) result++;
            if (hashMap.containsKey(sum - goal)) result += hashMap.get(sum - goal);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return result;

//        int result = 0;
//        for (int i = goal == 0 ? 1 : goal; i <= nums.length; i++) {
//            int currentSum = 0;
//            for (int j = 0; j < i; j++) currentSum += nums[j];
//            if (currentSum == goal) result++;
//            int start = 0, end = i;
//            while (end < nums.length) {
//                currentSum += nums[end++] - nums[start++];
//                if (currentSum == goal) result++;
//            }
//        }
//        return result;
    }
}
