package java;

/*
Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
*/
public class LongestSubarrayOf1sAfterDeletingOneElement1493 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 1}));
    }

    public static int longestSubarray(int[] nums) {
        int longest = 0;
        int deleted = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            deleted += (nums[i] == 0 ? 1 : 0);
            while (deleted > 1) {
                deleted -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
            longest = Math.max(longest, i - start);
        }
        return longest;
    }
}
