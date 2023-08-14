/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
*/
public class MaxConsecutiveOnesIII1004 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(longestOnes(new int[]{1, 0, 1, 1, 0}, 1));
        System.out.println(longestOnes(new int[]{0, 0, 0, 1}, 4));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 1, 0, 0}, 0));
    }

    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        while (i < nums.length) {
            k -= nums[i++] == 1 ? 0 : 1;
            if (k < 0)
                k += nums[j++] == 1 ? 0 : 1;
        }
        return i - j;

//        int longest = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                int[] newNums = Arrays.copyOf(nums, nums.length);
//                int currentK = k;
//                for (int j = i; j < newNums.length; j++) {
//                    if (currentK == 0) {
//                        break;
//                    }
//                    if (newNums[j] == 0) {
//                        newNums[j] = 1;
//                        currentK--;
//                    }
//                }
//                int currentLongest = 0;
//                for (int newNum : newNums) {
//                    if (newNum == 0) {
//                        if (longest < currentLongest) {
//                            longest = currentLongest;
//                        }
//                        currentLongest = 0;
//                    } else {
//                        currentLongest++;
//                    }
//                }
//                if (longest < currentLongest) {
//                    longest = currentLongest;
//                }
//            }
//        }
//        return longest;
    }
}
