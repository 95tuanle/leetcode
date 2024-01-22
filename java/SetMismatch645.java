/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.
*/
public class SetMismatch645 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] res = findErrorNums(nums);
        System.out.println(res[0] + " " + res[1]);

        int[] nums2 = {1, 1};
        int[] res2 = findErrorNums(nums2);
        System.out.println(res2[0] + " " + res2[1]);

        int[] nums3 = {2, 2};
        int[] res3 = findErrorNums(nums3);
        System.out.println(res3[0] + " " + res3[1]);

        int[] nums4 = {3, 2, 2};
        int[] res4 = findErrorNums(nums4);
        System.out.println(res4[0] + " " + res4[1]);
    }

    public static int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for (int num : nums) freq[num]++;
        int[] res = new int[2];
        for (int i = 1; i < freq.length; i++)
            if (freq[i] == 2) res[0] = i;
            else if (freq[i] == 0) res[1] = i;
        return res;

//        int[] res = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            int num = Math.abs(nums[i]);
//            if (nums[num - 1] < 0) res[0] = num;
//            else nums[num - 1] *= -1;
//        }
//        for (int i = 0; i < nums.length; i++)
//            if (nums[i] > 0) {
//                res[1] = i + 1;
//                break;
//            }
//        return res;

//        HashMap<Integer, Integer> freq = new HashMap<>();
//        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
//        int[] res = new int[2];
//        for (int i = 1; i <= nums.length; i++)
//            if (freq.getOrDefault(i, 0) == 2) res[0] = i;
//            else if (freq.getOrDefault(i, 0) == 0) res[1] = i;
//        return res;
    }
}
