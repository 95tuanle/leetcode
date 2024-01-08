package java;

/*
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
*/
public class IncreasingTripletSubsequence334 {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println(increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
        System.out.println(increasingTriplet(new int[]{1, 5, 0, 4, 1, 3}));
    }

    public static boolean increasingTriplet(int[] nums) {
        int firstElement = Integer.MAX_VALUE;
        int secondElement = Integer.MAX_VALUE;
        for (int num : nums)
            if (num <= firstElement) firstElement = num;
            else if (num <= secondElement) secondElement = num;
            else return true;
        return false;


//        for (int i = 0; i < nums.length - 2; i++) {
//            int positionOfTheSecondElement = i;
//            while (positionOfTheSecondElement < nums.length - 2 && nums[positionOfTheSecondElement] <= nums[i]) {
//                positionOfTheSecondElement++;
//            }
//            if (nums[positionOfTheSecondElement] <= nums[i]) {
//                continue;
//            }
//            int positionOfTheThirdElement = positionOfTheSecondElement;
//            while (positionOfTheThirdElement < nums.length - 1 && nums[positionOfTheThirdElement] <= nums[positionOfTheSecondElement]) {
//                positionOfTheThirdElement++;
//            }
//            if (positionOfTheThirdElement < nums.length && nums[positionOfTheThirdElement] > nums[positionOfTheSecondElement]) {
//                return true;
//            }
//        }
//        return false;
    }
}
